package ä��;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketSever {

   public static void main(String[] args) throws Exception {
      
      ServerSocket serverSocket = new ServerSocket(5523);
      
      while(true) {
         Socket socket = serverSocket.accept();
         System.out.println("ip : " + socket.getInetAddress() + "�� ���� ����");
         
         ReceiveThread rt = new ReceiveThread(socket);
         SendThread st = new SendThread(socket);
         
         rt.start();
         st.start();
      }

   }

}