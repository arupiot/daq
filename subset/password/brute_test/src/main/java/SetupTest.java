import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SetupTest {

  String host;
  int connectionPort;
  String macAddress;
  SshSocket sshSocket = null;
  TelnetSocket telnetSocket = null;
  String protocol;
  Map<String, String> macDevices = new HashMap<String, String>();
  boolean debug = false;
  static final int minimumMACAddressLength = 5;
  
  public void readFile() {
	  try {
		  System.out.println("Attempting to read web file...");
		  InputStream url = new URL("https://svn.nmap.org/nmap/nmap-mac-prefixes").openStream();
		  StringBuilder resultStringBuilder = new StringBuilder();
		  try (BufferedReader br= new BufferedReader(new InputStreamReader(url))){
			  String line;
			  while ((line = br.readLine()) != null) {
				  resultStringBuilder.append(line).append("\n");
				  String[] words = new String[2];
			      String macAddress;
			      String manufacturer;
			      if(line.length() > minimumMACAddressLength) {
			    	  macAddress = line.substring(0, 6);
			    	  manufacturer = line.substring(7, line.length());
			    	  if(manufacturer.length() > 0) {
			    		  macDevices.put(macAddress, manufacturer);
			    	  }
			      }
			  	}
		  }
		} catch (IOException e1) {
			System.out.println("Package Manager Error :" + e1);
			System.out.println("Attempting to read local file...");
			readLocalFile();
		}
  }
  
  public void readLocalFile() {
	try {
	  InputStream url = this.getClass().getResourceAsStream("/macList.txt");
	  StringBuilder resultStringBuilder = new StringBuilder();
	  BufferedReader br = new BufferedReader(new InputStreamReader(url));
	  String line;
	  while ((line = br.readLine()) != null) {
		resultStringBuilder.append(line).append("\n");
        String[] words = new String[2];
        String macAddress;
        String manufacturer;
        if (line.length() > minimumMACAddressLength) {
          macAddress = line.substring(0, 6);
          manufacturer = line.substring(7, line.length());
          if (manufacturer.length() > 0) {
        	  macDevices.put(macAddress, manufacturer);
          }
        }
	  }
	} catch (Exception e) {
		System.out.println(e);
		System.err.println("Can not read local file");
	}
  }

  public SetupTest(String protocol, String host, int connectionPort, String macAddress) {
    try {
      System.out.println("Package manager started...");
      this.host = host;
      this.connectionPort = connectionPort;
      this.macAddress = macAddress;

      readFile();

      switch (protocol) {
        case "ssh":
          setUpSshConnection();
          break;

        case "telnet":
          setUpTelnetConnection();
          break;
      }
    } catch (Exception e) {
      System.out.println("PackageManager CONSTRUCTOR:" + e.getMessage());
    }
  }

  public void setUpSshConnection() {
    sshSocket = new SshSocket(host, macDevices, connectionPort, macAddress);
    Thread sshThread = new Thread(sshSocket);
    sshThread.start();
  }

  public void setUpTelnetConnection() {
   telnetSocket = new TelnetSocket(host, macDevices, connectionPort, macAddress);
   Thread telnetThread = new Thread(telnetSocket);
   telnetThread.start();
   
  }
}
