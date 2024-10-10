package day4wkshp;

import java.io.*;
import java.net.*;

public class SendFile {
    private String host;
    private int port;
    private File file;
    public SendFile(String host,int port,File file){
        this.host = host;
        this.port = port;
        this.file = file;

    }

    public void send()throws IOException{
        Socket sock = new Socket(host,port);

        OutputStream os = sock.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.flush();
        bos.flush();
        os.flush();

        
        
    }
}

