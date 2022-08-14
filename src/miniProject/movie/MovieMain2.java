package miniProject.movie;

import java.util.Scanner;

public class MovieMain2 extends Thread {

	static int scanner() {

		Scanner sc = new Scanner(System.in);
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {

		String loginId = ""; // ������ : admin/admin
		int num = 0;
		MovieNow movieNow = new MovieNow();
		Movie movie = new Movie();
		Person person = new Person();
		ReservInfo reservInfo = new ReservInfo();

		String[] main = { //
				"#################################################################", //
				"##                                                             ##", //
				"##      ######   ######   ##   ##  ######   ##       ##        ##", //
				"##        ##       ##     ##   ##    ##     ##       ##        ##", //
				"##        ##       ##     ## # ##    ##     ##       ##        ##", //
				"##        ##       ##     ## # ##    ##     ##       ##        ##", //
				"##        ##       ##     ## # ##    ##     ##       ##        ##", //
				"##        ##       ##     ### ###    ##     ##       ##        ##", //
				"##      ######     ##     ##   ##  ######   ######   ######    ##", //
				"##                                                             ##", //
				"##                                                             ##", //
				"##       ####   ######   ##   ##  #######  ##   ##    ##       ##", //
				"##     ##   ##    ##     ###  ##  ##       ##   ##    ##       ##", //
				"##     ##         ##     ###  ##  ##       ### ###   ####      ##", //
				"##     ##         ##     ## # ##  #####    ## # ##   ## #      ##", //
				"##     ##         ##     ## # ##  ##       ## # ##  ######     ##", //
				"##      ##  ##    ##     ##  ###  ##       ##   ##  ##   #     ##", //
				"##       ####   ######   ##   ##  #######  ##   ## ###   ##    ##", //
				"##                                                             ##", //
				"#################################################################" //
		};

		for (int i = 0; i < main.length; i++) {
			try {
				sleep(0);
			} catch (Exception e) {
			}
			System.out.println(main[i]);
		}

		while (true) {
			
			if (loginId == "") { // �α׾ƿ� ����
				do {
					System.out.println("");
					System.out.println("		��������������������������������\n");
					System.out.println("		   1.�α��� 2.ȸ������ 3.����\n   ");
					System.out.println("		��������������������������������");
					System.out.println("�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� \n");
					System.out.printf(" �޴� ��ȣ : ");
					num = scanner();

				} while (num < 1 && num > 3);

				switch (num) {
				case 1:
					loginId = person.login(); // �α���
					break;
				case 2:
					person.input(); // ȸ������
					break;
				case 3:
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
				}
			}

			if (loginId.equals("admin")) { // ������ ����
				do {
					System.out.println("");
					System.out.println("�������������� ��     M     E     N     U     �� ������������\n");
					System.out.println("  1.��ȭ�߰�\t	2.��ȭ����\t	3.��ȭ����\n   ");
					System.out.println("  4.���߰�\t	5.�󿵼���\t	6.�����\n   ");
					System.out.println("  7.�α׾ƿ�\n");
					System.out.println("��������������������������������������������������������������\n");
					num = scanner();
				} while (num < 1 && num > 7);

				if ((num - 1) / 3 == 0)
					movie.print(); // ��ȭ ���
				else if ((num - 1) / 3 == 1)
					movieNow.print(); // �󿵿�ȭ ���

				switch (num) {
				case 1:
					movie.addMovie(); // 1.��ȭ�߰�
					break;
				case 2:
					movie.modifyMovie(); // 2.��ȭ����
					break;
				case 3:
					movie.deleteMovie(); // 3.��ȭ����
					break;
				case 4:
					movieNow.addMovieNow(movie); // 4.���߰�
					break;
				case 5:
					movieNow.modifyMovieNow(movie); // 5.�󿵼���
					break;
				case 6:
					movieNow.deleteMovieNow(movie); // 6.�����
					break;
				case 7:
					loginId = ""; // 7.�α׾ƿ�
					break;
				}

			} else if (!loginId.equals("")) { // �α��� ����
				do {
					System.out.println("");
					movieNow.print(); // �󿵿�ȭ ���
					System.out.println("���������������� ��     M     E     N     U     �� ��������������\n");
					System.out.println("   1.�����ϱ�\t   	  2.�������\t	3.ȸ����������\n	");
					System.out.println("   4.Ż��\t	  5.�α׾ƿ�	\n");
					System.out.println("������������������������������������������������������������������");
					System.out.println("�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� \n");
					System.out.printf(" �޴� ��ȣ : ");
					num = scanner();

				} while (num < 1 && num > 5);

				switch (num) {
				case 1:
					reservInfo.booking(person, movieNow, loginId); // 1.�����ϱ�
					break;
				case 2:
					reservInfo.cancelReserv(person, loginId); // 2.�������
					break;
				case 3:
					person.modify(loginId); // 3.ȸ����������
					break;
				case 4:
					person.deleteId(loginId); // 4.Ż��
				case 5:
					loginId = ""; // 5.�α׾ƿ�
					break;
				}

			}

		}
	}
}
