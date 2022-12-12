package ���Ͽ���;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

   public static void main(String[] args) {
      Socket socket = null;
      
      try {
         socket=new Socket();
         System.out.println("[���� ��û]");
         socket.connect(new InetSocketAddress("localhost",50001));
         System.out.println("[���� ����]");
         
         byte[] bytes = null;
         String message = null;
         
         OutputStream os = socket.getOutputStream();
         message = "hi Server";
         bytes= message.getBytes("utf-8");
         os.write(bytes);
         os.flush();
         System.out.println("[������ ������]");
     
         InputStream is= socket.getInputStream();
         bytes = new byte[100];
         int readByteCount = is.read(bytes);
         message = new String(bytes,0,readByteCount,"utf-8");
         System.out.println("[������ ����]"+message);
      
         os.close();
         is.close();
         
      }catch (Exception e) {
      }
      if(!socket.isClosed()) {
         try {
            socket.close();
         }catch (Exception e) {
         }
      }
   }

}