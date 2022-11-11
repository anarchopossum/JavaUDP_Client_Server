import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;
public class Server {

    public static void main(String[] args) throws Exception {
		/*
		 * This is the reciving part of the server, Here clients will send data
		*/
		// Set Port for incoming info
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a Port Number: ");
        int portVal = s.nextInt();
		System.out.println("Waiting for message from Client...");
        DatagramSocket dataSock = new DatagramSocket(portVal);
		// Set incomming size of data
        byte[] inbox = new byte[1024];
		// Sets datapacket info (the data, the size of the data)
        DatagramPacket dataPack = new DatagramPacket(inbox, inbox.length);
		// fetches the data from the client
        dataSock.receive(dataPack);
		// stores the information from the datapacket
        String mail = new String(dataPack.getData());
		System.out.println("Recived Mail:\n"+mail);

		/*
		 * Sending Data Back
		 */
        String sendBack = mail.toUpperCase();
        System.out.println("Sending back to: " + dataPack.getAddress());
		DatagramPacket returnLetter = new DatagramPacket(sendBack.getBytes(),
                mail.getBytes().length, dataPack.getAddress(), dataPack.getPort());
        dataSock.send(returnLetter);
        System.out.println("Letter Sent. :)");
        dataSock.close();
    }
}