package ä��;

import java.net.Socket;

public class SocketClient {

   public static void main(String[] args) {

      Socket socket = null;
      
      try {
         socket = new Socket("localhost", 5523);
         System.out.println("[���� ����]");
      } catch(Exception e) {
         System.out.println("[���� ����]");
      }
      
      if(socket != null) {
         RThread rt = new RThread(socket);
         SThread st = new SThread(socket);
         
         rt.start();
         st.start();
      }

   }

}