/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3;

import java.net.*;
import java.io.*;

/**
 *
 * @author bbalt
 */
public class EchoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10007);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("Waiting for connection.....");

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        System.out.println("Connection successful");
        System.out.println("Waiting for input.....");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        Protocol pro = new Protocol();
        String inputLine;
        System.out.println("HER");

        while ((inputLine = in.readLine()) != null) {

            if(!pro.checkPro(inputLine).equals("false")) {
                out.println(pro.checkPro(inputLine));
            }
            else {
                out.println("False");
                break;
            }
//            System.out.println("Server: " + inputLine);
//            out.println(inputLine);
//
//            if (inputLine.equals("Bye.")) {
//                break;
//            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }

}
