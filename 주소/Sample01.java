package �ּ�;

import java.net.InetAddress;

public class Sample01 {

	public static void main(String[] args) {

		// ip �ּ� �̾Ƴ���
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("����ǻ�� ip �ּ�: " + local.getHostAddress());

			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress r : iaArr) {
				System.out.println("���̹� ip �ּ�" + r.getHostAddress());
			}
		} catch (Exception e) {
		
		}
	}
}
