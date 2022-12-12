package ���Ͽ���;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

   public static void main(String[] args) {
      ServerSocket serverSocket = null;

      try {
         serverSocket = new ServerSocket();
         serverSocket.bind(new InetSocketAddress("localHost", 50001));

         while (true) {
            System.out.println("[������]");
            Socket socket = serverSocket.accept();

            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println("[�������] : " + isa.getHostName());

            byte[] bytes = null;
            String message= null;
            
            InputStream is= socket.getInputStream();
            bytes = new byte[100];
            int readByteCount = is.read(bytes);
            message = new String(bytes,0,readByteCount,"utf-8"); 
            System.out.println("[������ ����]"+message);
            
            OutputStream os= socket.getOutputStream();
            message = "hi Client";
            bytes = message.getBytes("utf-8");
            os.write(bytes);
            os.flush();
            System.out.println("[������ ������]");
            
            is.close();
            os.close();
            socket.close();
         }
      } catch (Exception e) {
         System.out.println("[�������]");
      }
      if (!serverSocket.isClosed()) {
         try {
            serverSocket.close();
         } catch (Exception e) {

         }
      }
   }

}