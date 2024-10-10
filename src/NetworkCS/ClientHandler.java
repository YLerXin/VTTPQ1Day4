package NetworkCS;

import java.net.*;
import java.io.*;
import java.util.*;
//work thread to perform
public class ClientHandler  implements Runnable{

    private final Socket sock;
    public ClientHandler(Socket s){
        sock = s;
    }
    //Entry point for thread
    @Override
    public void run(){

        String threadname = Thread.currentThread().getName();
        try{
        InputStream is = sock.getInputStream();
        Reader reader =new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        OutputStream os = sock.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);


        //Data from the clientside being read serverside
        String fromClient = br.readLine();

        System.out.printf(">>> FROM Client %s\n",threadname,fromClient);

        fromClient = (new Date()).toString() + " " + fromClient.toUpperCase();


        bw.write(fromClient);
        bw.newLine();
        bw.flush();
        os.flush();

        os.close();
        is.close();
        sock.close();}
        catch(IOException e){
            //Exception hander
            e.printStackTrace();
        }

    }
    
}
