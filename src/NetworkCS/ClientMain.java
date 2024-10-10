package NetworkCS;

import java.io.*;
import java.net.*;

public class ClientMain{
    public static void main(String[] args) throws IOException {
        int port =3000;
        if (args.length >0){
            port = Integer.parseInt(args[0]);
        }


        System.out.println("Connecting to the server");

        Socket sock = new Socket("localHost",port);
        System.out.println("Connected");

        Console cons = System.console();

        //Write a message to the server
        String theMessage = cons.readLine("Input: ");

        //get the output stream
        OutputStream os = sock.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);

        //get the input stream
        InputStream is = sock.getInputStream();
        Reader reader =new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        bw.write(theMessage);
        bw.newLine();
        bw.flush();
        os.flush();


        String fromServer = br.readLine();

        System.out.printf(">>> FROM SERVER %s\n",fromServer);

        os.close();
        is.close();
        sock.close();
    }
    
}
