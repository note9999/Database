package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
   
   Connection conn = null; //���� ���� ��ü ����
   Statement stmt = null; //Statement �� ������
   ResultSet rs = null; //���� �����ص� ��ü ����
   
   //������
   public MemberDAO() {
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         
         conn = DriverManager.getConnection(
               "jdbc:mariadb://localhost:3306/javadb",
               "root", "java1234"
               );
         
         /** �ڵ� �ۼ� ���
          * = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/dbName",
                    "userId",
                    "userPassword");
          */
               
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //db�� insert ��� ����ȭ �۾�
   public int insert(MemberVO vo) {
      int result = 0;
      
      try {
         String sql = "insert into member values(" + vo.getMemberno() + ", '" + vo.getId() + "','" + vo.getName() + "')";
         
         stmt = conn.createStatement(); //�����Ҵ�
         result = stmt.executeUpdate(sql); // (sql)�� �߰�&����
      } catch(Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   //db�� select ��� ����ȭ �۾�
   public MemberVO selectOne(int memberno) {
      
      MemberVO vo = new MemberVO();
      
      try {
         String sql = "select * from member where memberno=" + memberno;
         
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         if(rs.next()) {
            vo.setMemberno(rs.getInt("memberno"));
            vo.setId(rs.getString("id"));
            vo.setName(rs.getString("name"));
         }
      }catch (Exception e) {
         e.printStackTrace();
      }
         return vo;
   }

  
   public List<MemberVO> list() {
	      List<MemberVO> list = new ArrayList<>();

	      try {
	         String sql = "select*from member";

	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);

	         while (rs.next()) {
	            MemberVO vo = new MemberVO();

	            vo.setMemberno(rs.getInt("memberno"));
	            vo.setId(rs.getString("id"));
	            vo.setName(rs.getString("name"));

	            list.add(vo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return list;
   }
   }