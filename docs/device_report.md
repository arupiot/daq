# Device 9a:02:57:1e:8f:01, *** Make *** *** Model ***

## Test Roles

|  Role  |      Name              | Status |
|--------|------------------------|--------|
|Operator| *** Operator Name *** |        |
|Approver| *** Approver Name *** |        |

## Test Iteration

| Test             |                        |
|------------------|------------------------|
| Test report start date | 2019-09-02 15:10:31+00:00 |
| Test report end date   | 2019-09-02 15:23:33+00:00 |
| DAQ version      | 1.0.1 |
| Attempt number   | 1 |

## Device Identification

| Device            | Entry              |
|-------------------|--------------------|
| Name              | *** Name *** |
| GUID              | *** GUID *** |
| MAC addr          | 9a:02:57:1e:8f:01 |
| Hostname          | *** Network Hostname *** |
| Type              | *** Type *** |
| Make              | *** Make *** |
| Model             | *** Model *** |
| Serial Number     | *** Serial *** |
| Firmware Version  | *** Firmware Version *** |

## Device Description

![Image of device](*** Device Image URL ***)

*** Device Description ***


### Device documentation

[Device datasheets](*** Device Datasheets URL ***)
[Device manuals](*** Device Manuals URL ***)

## Report summary

Overall device result FAIL

|Category|Result|
|---|---|
|Security|PASS|
|Other|1/2|
|Connectivity|n/a|

|Expectation|pass|fail|skip|gone|
|---|---|---|---|---|
|Required|1|1|0|0|
|Recommended|1|0|0|0|
|Other|1|2|13|2|

|Result|Test|Category|Expectation|Notes|
|---|---|---|---|---|
|skip|base.switch.ping|Other|Other||
|pass|base.target.ping|Connectivity|Required|target|
|skip|cloud.udmi.pointset|Other|Other|No device id.|
|pass|connection.dhcp_long|Other|Other||
|fail|connection.mac_oui|Other|Other||
|fail|connection.min_send|Other|Other||
|skip|connection.port_duplex|Other|Other||
|skip|connection.port_link|Other|Other||
|skip|connection.port_speed|Other|Other||
|fail|network.brute|Security|Required||
|skip|poe.negotiation|Other|Other||
|skip|poe.power|Other|Other||
|skip|poe.support|Other|Other||
|skip|protocol.bacnet.pic|Other|Other|Bacnet device not found... Pics check cannot be performed.|
|skip|protocol.bacnet.version|Other|Other|Bacnet device not found.|
|skip|security.firmware|Other|Other|Could not retrieve a firmware version with nmap. Bacnet port could be closed or filtered|
|pass|security.ports.nmap|Security|Recommended||
|skip|security.tls.v3|Other|Other||
|skip|security.x509|Other|Other||
|gone|unknown.fake.llama|Other|Other||
|gone|unknown.fake.monkey|Other|Other||


## Module ping

```
Baseline ping test report
%% 80 packets captured.
RESULT skip base.switch.ping
RESULT pass base.target.ping target %% 10.20.22.164
```

## Module nmap

```
Allowing 10000 open tcp snet-sensor-mgmt
No invalid ports found.
RESULT pass security.ports.nmap
```

## Module brute

```
Username:manager
Password:friend
Login success!
RESULT fail network.brute
```

## Module discover

```
--------------------
security.firmware
--------------------
Automatic bacnet firmware scan using nmap
--------------------
PORT      STATE  SERVICE
47808/udp closed bacnet
MAC Address: 9A:02:57:1E:8F:01 (Unknown)
Firmware test complete
--------------------
RESULT skip security.firmware Could not retrieve a firmware version with nmap. Bacnet port could be closed or filtered
```

## Module switch

```
LOCAL_IP not configured, assuming no network switch.
RESULT skip connection.port_link
RESULT skip connection.port_speed
RESULT skip connection.port_duplex
RESULT skip poe.power
RESULT skip poe.negotiation
RESULT skip poe.support
```

## Module macoui

```
Mac OUI Test
RESULT fail connection.mac_oui
```

## Module bacext

```
RESULT skip protocol.bacnet.version Bacnet device not found.
RESULT skip protocol.bacnet.pic Bacnet device not found... Pics check cannot be performed.
```

## Module tls

```
IOException unable to connect to server.
RESULT skip security.tls.v3
RESULT skip security.x509
```

## Module udmi

```
RESULT skip cloud.udmi.pointset No device id.
```

## Module network

```
--------------------
connection.dhcp_long
--------------------
Device sends arp request packets on DHCP lease expiry
--------------------
%% 15:12:35.373072 ARP, Ethernet (len 6), IPv4 (len 4), Request who-has daq-faux-1 tell 10.0.0.1, length 28
%% 15:12:35.373260 ARP, Ethernet (len 6), IPv4 (len 4), Request who-has 10.0.0.1 tell daq-faux-1, length 28
%% 15:12:35.373281 ARP, Ethernet (len 6), IPv4 (len 4), Reply 10.0.0.1 is-at da:9f:9f:05:69:ca (oui Unknown), length 28
%% 15:12:35.373445 ARP, Ethernet (len 6), IPv4 (len 4), Reply daq-faux-1 is-at 9a:02:57:1e:8f:01 (oui Unknown), length 28
%% 15:16:14.508868 ARP, Ethernet (len 6), IPv4 (len 4), Request who-has daq-faux-1 tell 10.0.0.1, length 28
%% 15:16:14.509005 ARP, Ethernet (len 6), IPv4 (len 4), Request who-has 10.0.0.1 tell daq-faux-1, length 28
%% 15:16:14.509025 ARP, Ethernet (len 6), IPv4 (len 4), Reply 10.0.0.1 is-at da:9f:9f:05:69:ca (oui Unknown), length 28
%% 15:16:14.509095 ARP, Ethernet (len 6), IPv4 (len 4), Reply daq-faux-1 is-at 9a:02:57:1e:8f:01 (oui Unknown), length 28
%% 
%% packets_count=9
RESULT pass connection.dhcp_long %% arp_packets_received:9

--------------------
connection.min_send
--------------------
Device sends packets less than 5 minutes excluding arp packets
--------------------
RESULT fail connection.min_send %% arp_packets_received:9 %% all_packets_received:7

```

## Report complete

