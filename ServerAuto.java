package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAuto {

    static final int portNumber = 1234;


    public static void main(String[] args) {


        // Server TCP
        System.out.println("Server  Car  started!");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert clientSocket != null;
            ClientHandler clientHandler = new ClientHandler(clientSocket);

            // ClientManager.getInstance().add(clientHandler);
            Thread thread = new Thread(clientHandler);
            thread.start();
            System.out.println("Server Conected!");
        }



}
}

