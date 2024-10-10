package day4wkshp;

import java.io.*;

public class FileTransfer {
    public static void main(String[] args) {
        if (args.length < 0){
            System.err.println("missing file name");
            System.exit(-1);
        }

        File file = new File(args[0]);
        String fileName = file.getName();

        long fileSize = file.length();

        System.out.printf("Transfering file %s\n",fileName);

        SendFile send = new SendFile("localhost", port, file)
    }
    
}
