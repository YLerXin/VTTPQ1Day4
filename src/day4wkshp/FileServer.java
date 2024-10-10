package day4wkshp;
//modify for multiple files?

import java.io.*;
import java.net.*;
import java.util.*;

public class FileServer {


        public static void main(String[] args) throws IOException {
            int port = 3000;

            // if(args.length > 0 ){
            //     port  =Integer.parseInt(args[0]);
            // }
            //create server port
            ServerSocket server = new ServerSocket(port);

            while(true){
            System.out.println("Waiting for connection...");
            Socket sock = server.accept();

            InputStream is = sock.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            String fileName = dis.readUTF();
            long fileSize = dis.readLong();

            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int bytesRead = 0;
            int recvBytes = 0;
            byte[] buff = new byte[4*1024];

            while (recvBytes < fileSize){
                bytesRead = dis.read(buff);
                bos.write(buff,0,bytesRead);
                recvBytes += bytesRead;
                System.out.printf("Received %d of %d\n",recvBytes,fileSize);


            }
            // Close the new file
            bos.flush();
            fos.close();

            // Close the socket
            dis.close();
            bis.close();
            is.close();
            sock.close();
            

            }


            
        }


}