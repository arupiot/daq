import subprocess
import time
import sys

arguments = sys.argv

test_request = str(arguments[1])
cap_pcap_file = str(arguments[2])
device_address = str(arguments[3])

connection_app_min_send_mode = len(arguments) > 4

if connection_app_min_send_mode:
    module_config = str(arguments[4])
    infastructure_exclude_file = str(arguments[5])

report_filename = 'report.txt'
min_packet_length_bytes = 20
max_packets_in_report = 10
packet_request_list = []
ignore = '%%'
summary = ''
dash_break_line = '--------------------\n'
description_min_send = 'Device sends data at a frequency of less than 5 minutes.'
description_dhcp_long = 'Device sends ARP request on DHCP lease expiry.'

tcpdump_display_all_packets = 'tcpdump -n src host ' + device_address + ' -r ' + cap_pcap_file
tcpdump_display_udp_bacnet_packets = 'tcpdump -n udp dst portrange 47808-47809 ' + cap_pcap_file
tcpdump_display_arp_packets = 'tcpdump -v arp -r ' + cap_pcap_file
tcpdump_display_ntp_packets = 'tcpdump dst port 123 -r ' + cap_pcap_file
tcpdump_display_eapol_packets = 'tcpdump port 1812 or port 1813 or port 3799 ' + cap_pcap_file
tcpdump_display_umb_packets = 'tcpdump -n ether broadcast and ether multicast ' + cap_pcap_file

def write_report(string_to_append):
    with open(report_filename, 'a+') as file_open:
        file_open.write(string_to_append)

def shell_command_with_result(command, wait_time, terminate_flag):
    process = subprocess.Popen(command, universal_newlines=True, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    text = process.stdout.read()
    retcode = process.wait()
    time.sleep(wait_time)
    if terminate_flag:
        process.terminate()
    if len(text) > 0:
        return text

def add_packet_info_to_report(packets_received, packet_request_list):
    global max_packets_in_report
    if packets_received > max_packets_in_report:
        max = max_packets_in_report
    else:
        max = packets_received
    for x in range(0, max):
        write_report("{i} {p}\n".format(i=ignore, p=packet_request_list[x]))
    write_report("{i} packets_count={p}\n".format(i=ignore, p=packets_received))

def decode_shell_result(shell_result):
    global packet_request_list
    if len(shell_result) > min_packet_length_bytes:
        packet_request_list = shell_result.split("\n")
        packets_received = len(packet_request_list)
        return packets_received

def packets_received_count(shell_result):
    if shell_result is None:
        return 0
    else:
        return decode_shell_result(shell_result)

def test_connection_min_send():
    shell_result = shell_command_with_result(tcpdump_display_arp_packets, 0, False)
    arp_packets_received = packets_received_count(shell_result)
    if arp_packets_received > 0:
        add_summary("ARP packets received. ")
    shell_result = shell_command_with_result(tcpdump_display_all_packets, 0, False)
    all_packets_received = packets_received_count(shell_result)
    if all_packets_received > 0:
        add_summary("Packets received.\n")
    if (all_packets_received - arp_packets_received) > 0:
        add_packet_info_to_report(arp_packets_received, packet_request_list)
        return 'pass'
    else:
        return 'fail'

def test_connection_dhcp_long():
    shell_result = shell_command_with_result(tcpdump_display_arp_packets, 0, False)
    arp_packets_received = packets_received_count(shell_result)
    if arp_packets_received > 0:
        add_summary("ARP packets received.\n")
        add_packet_info_to_report(arp_packets_received, packet_request_list)
        return 'pass'
    else:
        return 'fail'

def add_summary(text):
    global summary
    summary += text

write_report("{b}{t}\n{b}".format(b=dash_break_line, t=test_request))

if test_request == 'connection.min_send':
    write_report("{d}\n{b}".format(b=dash_break_line, d=description_min_send))
    result = test_connection_min_send()
elif test_request == 'connection.dhcp_long':
    write_report("{d}\n{b}".format(b=dash_break_line, d=description_dhcp_long))
    result = test_connection_dhcp_long()

write_report("RESULT {r} {t} {s}\n".format(r=result, t=test_request, s=summary))