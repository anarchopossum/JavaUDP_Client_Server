import java.lang.FdLibm.Pow;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;
public class Server {

    public static void main(String[] args) throws Exception {
		/*
		 * This is the reciving part of the server, Here clients will send data
		*/
		// Set Port for incoming info
        DatagramSocket dataSock = new DatagramSocket(4200);
		// Set incomming size of data
        byte[] inbox = new byte[1024];
		// Sets datapacket info (the data, the size of the data)
        DatagramPacket dataPack = new DatagramPacket(inbox, inbox.length);
		// fetches the data from the client
        dataSock.receive(dataPack);
		// stores the information from the datapacket
        String mail = new String(dataPack.getData());
		
		/*
		 * Sending Data Back
		 */
		int val = Integer.parseInt(mail.trim());
		int sqr = val*val;
		byte[] byte2 = (sqr+ "").getBytes();
		InetAddress local = InetAddress.getLocalHost();
		DatagramPacket letter = new DatagramPacket(byte2, byte2.length, local, dataPack.getPort());

    }
}