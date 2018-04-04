
package datagramreceiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DatagramSender {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException {
        String[] lista = new String[3];
        lista[0] = "Winners never quit, quitters never win";
        lista[1] = "In vino veritas";
        lista[2] = "Only a madman would do the same thing twice, and expect different results";
        
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 55555;
        int i = 0;
        DatagramSocket socket = new DatagramSocket();
        String message;
        System.out.println("?: ");
        while (true){
           // if (message.equals("bye")) System.exit(0);
            byte[] data = lista[i++].getBytes();
            Thread.sleep(1000);
            if (i == 3){
                i = 0;
            }
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            //System.out.println(message);
        
        
        }
        
    }
    
}
