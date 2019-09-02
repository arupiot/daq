public class Main {

  public static void main(String[] args) {

    if (args.length != 3) {
      throw new IllegalArgumentException("Usage: target_ip target_port target_mac");
    }

    String host = args[0];
    int connectionPort = Integer.parseInt(args[1]);
    String macAddress = args[2];

    SetupTest setupTest = new SetupTest(host, connectionPort, macAddress);
  }
}
