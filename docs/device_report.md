# Device 9a:02:57:1e:8f:01, *** Make *** *** Model ***

## Test Roles

|  Role  |      Name              | Status |
|--------|------------------------|--------|
|Operator| *** Operator Name *** |        |
|Approver| *** Approver Name *** |        |

## Test Iteration

| Test             |                        |
|------------------|------------------------|
| Test report start date | 2019-10-01 11:34:31+00:00 |
| Test report end date   | 2019-10-01 11:46:13+00:00 |
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

|Expectation|pass|fail|skip|info|gone|
|---|---|---|---|---|---|
|Required|1|1|0|0|0|
|Recommended|1|0|0|0|0|
|Other|2|3|13|1|2|

|Result|Test|Category|Expectation|Notes|
|---|---|---|---|---|
|skip|base.switch.ping|Other|Other||
|pass|base.target.ping|Connectivity|Required|target|
|skip|cloud.udmi.pointset|Other|Other|No device id|
|info|communication.type|Other|Other|Broadcast packets received. Multicast packets received.|
|pass|connection.dhcp_long|Other|Other|ARP packets received.|
|fail|connection.mac_oui|Other|Other||
|pass|connection.min_send|Other|Other|ARP packets received. Packets received.|
|skip|connection.port_duplex|Other|Other|No local IP|
|skip|connection.port_link|Other|Other|No local IP|
|skip|connection.port_speed|Other|Other|No local IP|
|fail|network.brute|Security|Required||
|fail|network.ntp.support|Other|Other||
|skip|poe.negotiation|Other|Other|No local IP|
|skip|poe.power|Other|Other|No local IP|
|skip|poe.support|Other|Other|No local IP|
|fail|protocol.app_min_send|Other|Other||
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
%% 69 packets captured.
RESULT skip base.switch.ping
RESULT pass base.target.ping target %% 10.20.28.164
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
--------------------
RESULT skip security.firmware Could not retrieve a firmware version with nmap. Bacnet port could be closed or filtered

```

## Module switch

```
--------------------
connection.port_link
--------------------
description
--------------------
LOCAL_IP not configured, assuming no network switch.
--------------------
RESULT skip connection.port_link No local IP

--------------------
connection.port_speed
--------------------
description
--------------------
LOCAL_IP not configured, assuming no network switch.
--------------------
RESULT skip connection.port_speed No local IP

--------------------
connection.port_duplex
--------------------
description
--------------------
LOCAL_IP not configured, assuming no network switch.
--------------------
RESULT skip connection.port_duplex No local IP

--------------------
poe.power
--------------------
description
--------------------
LOCAL_IP not configured, assuming no network switch.
--------------------
RESULT skip poe.power No local IP

--------------------
poe.negotiation
--------------------
description
--------------------
LOCAL_IP not configured, assuming no network switch.
--------------------
RESULT skip poe.negotiation No local IP

--------------------
poe.support
--------------------
description
--------------------
LOCAL_IP not configured, assuming no network switch.
--------------------
RESULT skip poe.support No local IP

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
--------------------
cloud.udmi.pointset
--------------------
Validates the payloads from the DUT to a predefined schema
--------------------
Device id is null, skipping.
--------------------
RESULT skip cloud.udmi.pointset No device id

```

## Module network

```
--------------------
connection.dhcp_long
--------------------
Device sends ARP request on DHCP lease expiry.
--------------------
%% 11:34:59.302582 ARP, Request who-has daq-faux-1 tell 10.0.0.5, length 28
%% 11:34:59.302797 ARP, Reply daq-faux-1 is-at 9a:02:57:1e:8f:01 (oui Unknown), length 28
%% 11:35:47.174991 ARP, Request who-has daq-faux-1 tell 10.0.0.5, length 28
%% 11:35:47.175073 ARP, Request who-has 10.0.0.5 tell daq-faux-1, length 28
%% 11:35:47.175082 ARP, Reply 10.0.0.5 is-at 4e:fc:27:e2:aa:20 (oui Unknown), length 28
%% 11:35:47.175729 ARP, Reply daq-faux-1 is-at 9a:02:57:1e:8f:01 (oui Unknown), length 28
%% 11:39:11.974982 ARP, Request who-has daq-faux-1 tell 10.0.0.5, length 28
%% 11:39:11.975118 ARP, Request who-has 10.0.0.5 tell daq-faux-1, length 28
%% 11:39:11.975132 ARP, Reply 10.0.0.5 is-at 4e:fc:27:e2:aa:20 (oui Unknown), length 28
%% 11:39:11.975504 ARP, Reply daq-faux-1 is-at 9a:02:57:1e:8f:01 (oui Unknown), length 28
%% packets_count=11
RESULT pass connection.dhcp_long ARP packets received.

--------------------
connection.min_send
--------------------
Device sends data at a frequency of less than 5 minutes.
--------------------
%% 11:34:59.302797 ARP, Reply 10.20.28.164 is-at 9a:02:57:1e:8f:01, length 28
%% 11:35:04.262545 IP 10.20.28.164.41755 > 224.1.1.1.47808: UDP, length 32
%% 11:35:04.272438 IP 10.20.28.164.35514 > 10.255.255.255.47808: UDP, length 32
%% 11:35:14.271831 IP 10.20.28.164.58132 > 224.1.1.1.47808: UDP, length 32
%% 11:35:14.282693 IP 10.20.28.164.49656 > 10.255.255.255.47808: UDP, length 32
%% 11:35:24.273896 IP 10.20.28.164.55710 > 224.1.1.1.47808: UDP, length 32
%% 11:35:24.291605 IP 10.20.28.164.32946 > 10.255.255.255.47808: UDP, length 32
%% 11:35:34.275039 IP 10.20.28.164.39452 > 224.1.1.1.47808: UDP, length 32
%% 11:35:34.294207 IP 10.20.28.164.43395 > 10.255.255.255.47808: UDP, length 32
%% 11:35:41.978317 IP 10.20.28.164.68 > 10.0.0.5.67: BOOTP/DHCP, Request from 9a:02:57:1e:8f:01, length 300
%% packets_count=11
RESULT pass connection.min_send ARP packets received. Packets received.

--------------------
communication.type
--------------------
Device sends unicast, multicast or broadcast packets.
--------------------
RESULT info communication.type Broadcast packets received. Multicast packets received. 
--------------------
protocol.app_min_send
--------------------
Device sends apllication packets at a frequency of less than 5 minutes.
--------------------
RESULT fail protocol.app_min_send 
--------------------
network.ntp.support
--------------------
Device sends NTP request packets.
--------------------
RESULT fail network.ntp.support 
```

## Report complete

