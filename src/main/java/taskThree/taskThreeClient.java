package taskThree;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Dora Di
 */

public class taskThreeClient{
    public static void main(String args[])throws Exception
    {
        byte b[]=new byte[1024];
        FileInputStream f=new FileInputStream("D:/srcfile.txt");
        DatagramSocket dsoc=new DatagramSocket(2000);
        int i=0;
        while(f.available()!=0)
        {
            b[i]=(byte)f.read();
            i++;
        }
        f.close();
        dsoc.send(new DatagramPacket(b,i,InetAddress.getLocalHost(),1000));
    }
}




/*
public class taskThreeClient
{
    // Client needs to know server identification, <IP:port>
    private static final int serverPort = 7777;

    // buffers for the messages
    public static String message;
    private static byte[] dataIn = new byte[256];
    private static byte[] dataOut = new byte[256];

    // In UDP messages are encapsulated in packages and sent over sockets
    private static DatagramPacket requestPacket;
    private static DatagramPacket responsePacket;
    private static DatagramSocket clientSocket;

    public static void main(String[] args) throws IOException
    {
        clientSocket = new DatagramSocket();
        InetAddress serverIP = InetAddress.getByName("127.0.0.1");
        System.out.println(serverIP);

        Scanner scan = new Scanner(System.in);
        System.out.println("Type message: ");

        while((message = scan.nextLine()) != null)
        {
            sendRequest(serverIP);
            receiveResponse();
        }
        clientSocket.close();
    }

    public static void sendRequest(InetAddress serverIP) throws IOException
    {
        //clientSocket = new DatagramSocket();
        dataOut = message.getBytes();
        requestPacket = new DatagramPacket(dataOut, dataOut.length, serverIP, serverPort);
        clientSocket.send(requestPacket);
    }

    public static void receiveResponse() throws IOException
    {
        //clientSocket = new DatagramSocket();
        responsePacket = new DatagramPacket(dataIn, dataIn.length);
        clientSocket.receive(responsePacket);
        String message = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("Response from Server: " + message);
    }
}
*/