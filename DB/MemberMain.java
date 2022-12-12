package DB;

import java.util.List;

public class MemberMain {

   public static void main(String[] args) {
      
      //insert �߰��� �����͸� �����ϴ� ��ü
      MemberVO vo = new MemberVO();
      vo.setMemberno(5);
      vo.setId("����");
      vo.setName("����");
      
      MemberDAO dao = new MemberDAO();
      
      int r = dao.insert(vo);
   
      if(r > 0) {
         System.out.println("ȸ�� ��� ����");
      }
      
      //select �˻��� ����� �����ϴ� ��ü
      MemberVO rvo = new MemberVO();
      rvo = dao.selectOne(5);
      
      System.out.println("==�������==");
      System.out.println("��ȣ : " + rvo.getMemberno());
      System.out.println("���̵� : " + rvo.getId());
      System.out.println("�̸� : " + rvo.getName());
      
      System.out.println("=====��üȸ�� ����=====");
      List<MemberVO>list = dao.list();
      
      for(int i =0;i<list.size();i++) {
         System.out.println("��ȣ : "+list.get(i).getMemberno()+"\t ���̵� : "+list.get(i).getId()+
                         "\t �̸�: "+list.get(i).getName());
      }
      
   }

}