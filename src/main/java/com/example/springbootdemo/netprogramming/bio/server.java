package com.example.springbootdemo.netprogramming.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
         ServerSocket serverSocket = new ServerSocket();
         serverSocket.bind(new InetSocketAddress(9999));
         System.out.println("启动server............");
         try{
             while(true){
                 new Thread(new ServerTask(serverSocket.accept())).start();
             }

         }catch(Exception e){
             e.printStackTrace();
         }finally {

         }


    }
    private static class ServerTask implements Runnable{
        private Socket socket;

        public ServerTask(Socket socket) throws IOException {
            this.socket = socket;
        }

        @Override
        public void run() {
            try(ObjectInputStream inputStream =
                        new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream =
                        new ObjectOutputStream(socket.getOutputStream());){
                String userName = inputStream.readUTF();
                System.out.println("Accept client message:"+userName);
                outputStream.writeUTF("hello:"+userName);
                outputStream.flush();

            }catch(Exception e){
                e.printStackTrace();

            } finally{
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
