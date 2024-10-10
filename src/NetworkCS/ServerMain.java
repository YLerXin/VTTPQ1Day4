package NetworkCS;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerMain {
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

        //Open input stream first for Server

                //get the input stream
        InputStream is = sock.getInputStream();
        Reader reader =new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        OutputStream os = sock.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);


        //Data from the clientside being read serverside
        String fromClient = br.readLine();

        System.out.printf(">>> FROM Client %s\n",fromClient);

        fromClient = (new Date()).toString() + " " + fromClient.toUpperCase();


        bw.write(fromClient);
        bw.newLine();
        bw.flush();
        os.flush();


    

        os.close();
        is.close();
        sock.close();
    }
}





}
