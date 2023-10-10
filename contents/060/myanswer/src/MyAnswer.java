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
                            // インターフェイスの起動確認・ループバックインターフェースか確認・仮想インターフェースか確認
                            return networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isVirtual();
                        } catch (SocketException e) {
                            return false;
                        }
                    })
                    .forEachOrdered(networkInterface -> {
                        try {
                            byte[] macBytes = networkInterface.getHardwareAddress();
                            if (macBytes == null) {
                                return;
                            }

                            StringBuilder macAddress = new StringBuilder();
                            for (byte b : macBytes) {
                                macAddress.append(String.format("%02X:", b)); // バイトを16進数文字列に変換
                            }
                            if (macAddress.length() > 0) {
                                macAddress.deleteCharAt(macAddress.length() - 1); // 末尾のコロンを削除
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
