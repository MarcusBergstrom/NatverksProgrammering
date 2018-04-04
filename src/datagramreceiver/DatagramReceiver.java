
package datagramreceiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class DatagramReceiver {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        InetAddress toAdr = InetAddress.getLocalHost();
        int minPort = 55555;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];
        while(true){
            
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Meddelande från:  "+packet.getAddress().getHostAddress());
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        }
    }
    
}
