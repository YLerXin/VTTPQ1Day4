package NetworkCS;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedServer {

    //create threadpool;
    private static ExecutorService thrPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException{

        int port = 3000;

        if(args.length > 0 ){
            port  =Integer.parseInt(args[0]);
        }
        //create server port
        ServerSocket server = new ServerSocket(port);


        while(true){

        //wait for incoming connection
        System.out.printf("Waiting for connection on port %d\n", port);
        Socket sock = server.accept();

        System.out.println("Got a new connection");

        // Create a worker to handle the work
        ClientHandler handler = new ClientHandler(sock);
        //pss the work to the worker
        thrPool.submit(handler);
    }
}





}
