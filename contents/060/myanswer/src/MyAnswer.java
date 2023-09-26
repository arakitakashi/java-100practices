import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class MyAnswer {

    public static void main(String[] args) {
        try {
            NetworkInterface.networkInterfaces()
                    .filter(networkInterface -> {
                        try {
                            return networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isVirtual();
                        } catch (SocketException e) {
                            return false;
                        }
                    })
                    .forEachOrdered(networkInterface -> {
                        try {
                            byte[] macBytes = networkInterface.getHardwareAddress();
                            if (macBytes == null) {
                                return;  // Skip interfaces without a MAC address
                            }

                            StringBuilder macAddress = new StringBuilder();
                            for (byte b : macBytes) {
                                macAddress.append(String.format("%02X:", b));
                            }
                            if (macAddress.length() > 0) {
                                macAddress.deleteCharAt(macAddress.length() - 1);  // Remove trailing colon
                            }

                            networkInterface.inetAddresses()
                                    .forEach(inetAddress -> {
                                        String fqdn = inetAddress.getCanonicalHostName();
                                        String ipAddress = inetAddress.getHostAddress();
                                        System.out.printf("FQDN: %s, IP Address: %s, MAC Address: %s%n", fqdn, ipAddress, macAddress);
                                    });
                        } catch (SocketException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
