package day4wkshp;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientMain{

    public static void main(String[] args)throws IOException {
        if (args.length <= 0){
            System.err.println("No file Specified");
            System.exit(-1);
        }

        int port = 3000;

        File file = new File(args[0]);

        Socket sock = new Socket("localhost",port);

        OutputStream os = sock.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        String fileName = file.getName();
        long filesize = file.length();

        dos.writeUTF(fileName);
        dos.writeLong(filesize);

        int readBytes = 0;
        int sendbytes = 0;
        byte[] buff = new byte[4*1024];

        while (((readBytes = bis.read(buff)) > 0 )){
            sendbytes += readBytes;
            dos.write(buff,0,readBytes);
            System.out.printf("Send %d of %d\n", sendbytes, filesize);

        }
        // Close the file
        bis.close();
        fis.close();

        // Flush connection
        dos.flush();
        bos.flush();
        os.flush();

        // Close connection
        dos.close();
        bos.close();
        os.close();
        sock.close();



    }



}