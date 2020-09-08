package taskTwo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class taskTwoThreadServer implements Runnable {
    public static Socket opensocket;


    public taskTwoThreadServer(Socket e) {
        this.opensocket = e;
    }

    public void run()  {
        String request, response;
        System.out.println("starting new session");
        // two I/O streams attached to the server socket:
        Scanner in;         // Scanner is the incoming stream (requests from a client)
        PrintWriter out;    // PrintWriter is the outcoming stream (the response of the server)
        try {
            in = new Scanner(opensocket.getInputStream());
            out = new PrintWriter(opensocket.getOutputStream(),true);
            while(in.hasNextLine())
            {
                request = in.nextLine();

                if(request.equals("stop"))
                {
                    out.println("Good bye, client!");
                    System.out.println("Log: " + request + " client!");
                    break;
                }
                else
                {
                    // server responses
                    response = new StringBuilder(request).reverse().toString();
                    out.println(response);
                    // Log response on the server's console, too
                    System.out.println("Log: " + response);
                }
            }
            System.out.println("Closing a session");
            opensocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Parameter true ensures automatic flushing of the output buffer
        // Server keeps listening for request and reading data from the Client,
        // until the Client sends "stop" requests
    }
}
