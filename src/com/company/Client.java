package com.company;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1111);

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());

        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);

        Scanner scanner = new Scanner(System.in);

        while (true){
            String msgToSend=scanner.nextLine();

            bw.write(msgToSend);
            bw.newLine();
            bw.flush();

            System.out.println("Server: "+ br.readLine());
            if( msgToSend.equalsIgnoreCase("BYE")){
                break;
            }
        }

//        String str = br.readLine();
//        System.out.println("client" + str);
        
//        Socket socket = new Socket();
//        socket.connect(new InetSocketAddress("localhost", 1111));
//        Scanner scanner = new Scanner(socket.getInputStream());
//        while (scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine());
//        }

    }
}
