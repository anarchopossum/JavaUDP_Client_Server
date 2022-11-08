import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         *This is where the client will send data
         */
        // Creates a DatagramSocket
        DatagramSocket dataSock = new DatagramSocket();
        // gets the machines address
        InetAddress myAddy = InetAddress.getLocalHost();
        // Data that will be sent over the network
        String loveLetter = "Never gonna give you up!";
        // changes the String to bytes to send over the network
        byte[] Translate = loveLetter.getBytes();
        // Sets up the DatagramPacket with (data,data length, my address, port number)
        DatagramPacket Postman = new DatagramPacket(Translate, Translate.length, myAddy, 4200);
        // Sends the packet
        dataSock.send(Postman);

        /*
         * This is where the client will be able to receive data
         */
        // Creates a new byte that will hold the received data
        byte[] reply = new byte[1024];
        // setup for data being received
        DatagramPacket box = new DatagramPacket(reply, reply.length);
        // Actual package is received
        dataSock.receive(box);
        // Read the Data from the "box"
        String readIt = new String(box.getData());
        System.out.printf(readIt);
        // Closes the Socket via timeout
        dataSock.setSoTimeout(3000);
    }
}
