public class Main {
    public static void main(String[] args){
        // telnet OR ssh AS A PROTOCOL

        if (args.length != 5) {
            throw new IllegalArgumentException(
                    "Usage: target_ip protocol(ssh/telnet) target_port target_mac");
        }

        String host = args[0];

        String protocol = args[1];
        String port = args[2];
        String macAddress = args[3];
        String domain = args[4];
        //127.0.0.1 telnet 32768 02:42:ac:11:00:02
//        String host = "127.0.0.1";
//        String domain = "my-site.com";
//        String protocol = "ssh";
//        String connectionPort = "45";
//        String macAddress = "02:42:ac:11:00:02";
//        System.out.println("Main Started...");
        SetupTest setupTest = new SetupTest(protocol, host, port, macAddress,domain);
    }
}
