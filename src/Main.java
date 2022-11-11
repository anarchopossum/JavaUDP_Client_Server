import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         *This is where the client will send data
         */
        Scanner s = new Scanner(System.in);
        // Asks the User to input Location, port, and message
        System.out.println("Enter IP/Domain Name:");
        String direction = s.nextLine();
        System.out.println("Enter PortNumber:");
        String portNum = s.nextLine();
        System.out.println("Enter the Text you want to Send:");
        String loveLetter = s.nextLine();
        // Creates a DatagramSocket
        DatagramSocket dataSock = new DatagramSocket();
        // Data that will be sent over the network
        // changes the String to bytes to send over the network
        byte[] Translate = loveLetter.getBytes();
        // Sets up the DatagramPacket with (data,data length, my address, port number)
        DatagramPacket Postman = new DatagramPacket(Translate, Translate.length, InetAddress.getByName(direction), Integer.parseInt(portNum));
        // Sends the packet
        dataSock.send(Postman);
        System.out.println("Letter Sent");

        /*
         * This is where the client will be able to receive data
         */
         System.out.println("Waiting on Response...");
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
         System.out.println("\ndone!");
    }
}
