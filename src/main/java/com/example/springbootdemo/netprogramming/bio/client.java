package com.example.springbootdemo.netprogramming.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1",9999);
        try{
            socket = new Socket();
            socket.connect(addr);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output.writeUTF("代发费");
            output.flush();
            System.out.println(input.readUTF());

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(socket!=null) socket.close();
            if(output!=null) output.close();
            if(input!=null) input.close();

        }


    }
}
