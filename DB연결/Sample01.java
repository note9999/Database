package DB����;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sample01 {

   public static void main(String[] args) {
      
      Connection conn = null; //�������ִ� Ŀ�ؼ� ��ü ����
      
      try {
         /**�Ʒ� ���� �ڵ�(��� ��� ����) */
         Class.forName("org.mariadb.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javadb", "root", "java1234");
         
   
         
      } catch (Exception e) {
         
      } finally {
         if(conn != null) {
            try {
               conn.close();
            } catch(Exception e) {

            }
         }
         
      }
      
      if(conn != null)
         System.out.println("�����ͺ��̽� ����");

   }

}