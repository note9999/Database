package ä��;

import java.io.DataInputStream;
import java.net.Socket;

public class ReceiveThread extends Thread {

   private final Socket socket;

   public ReceiveThread(Socket socket) {
      this.socket = socket;
   }
   
   public void run() {
      try {
         DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
         String message;
         
         while(true) {
            message = tmpbuf.readUTF();
            System.out.println("���� : " + message);
         }
      } catch(Exception e) {
         System.out.println("[���� ����]");
      }
      
   }
   
   
}