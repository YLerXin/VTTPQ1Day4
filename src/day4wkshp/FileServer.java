package day4wkshp;
//incomplete to review using profs code

import java.io.*;
import java.net.*;
import java.util.*;

public class FileServer {


        public static void main(String[] args) throws IOException {
            int port = 3000;

            if(args.length > 0 ){
                port  =Integer.parseInt(args[0]);
            }
            //create server port
            ServerSocket server = new ServerSocket(port);

            Socket sock = server.accept();

            OutputStream os = sock.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);




            
        }


}