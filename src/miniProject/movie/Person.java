package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Person {

	Scanner sc = new Scanner(System.in);

	List<PersonVO> lists = new ArrayList<>();
	PersonVO vo;

	// ȸ������
	public void input() {
		vo = new PersonVO();

		inputId();
		inputPw();
		inputName();
		inputRgnum();
		inputPhone();

		lists.add(vo);
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�. �α��� �� �̿��� �ֽñ� �ٶ��ϴ�.");

	}

	// ȸ������ - id �Է� �޼ҵ�
	public void inputId() {
		boolean result2 = false;
		String id;

		do {
			System.out.print("ID�� �Է��� �ּ���: ");
			id = sc.nextLine();

			if (id.equals("admin")) {
				System.out.println("������ ID�� ������ �� �����ϴ�. �ٽ� �Է��� �ּ���.");
			} else {
				break;
			}

			Iterator<PersonVO> it = lists.iterator();

			while (it.hasNext()) {

				vo = it.next();

				if (id.equals(vo.getId())) {

					System.out.print("������ ID�� �����մϴ�. �ٽ� �Է��� �ּ���.");
					continue;

				}
			}
		} while (!result2);

		vo.setId(id);
	}

	// ȸ������ - pw �Է� �޼ҵ�
	public void inputPw() {

		String pw2;

		do {
			System.out.print("��й�ȣ�� �Է��� �ּ���: ");
			vo.setPw(sc.nextLine());
			System.out.print("��й�ȣ ��Ȯ���� ���� �Է��� �ּ���: ");
			pw2 = sc.nextLine();

			if (pw2.equals(vo.getPw())) {
				break;
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. ���Է� ���ּ���.");
			}
		} while (!pw2.equals(vo.getPw()));
	}

	// ȸ������ - �̸� �Է� �޼ҵ�
	public void inputName() {
		System.out.print("�̸��� �Է��� �ּ���: ");
		vo.setName(sc.nextLine());
	}

	// ȸ������ - �ֹε�Ϲ�ȣ �Է� �޼ҵ�
	public void inputRgnum() {

		String regex = "^[0-9]{6}-[1234][0-9]{6}$"; // �ֹι�ȣ ����ȭ ǥ����

		int[] chk = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int i, tot, su = 0;
		boolean result = false;

		while (true) {
			do {
				System.out.print("Ư������(-)�� ������ �ֹε�Ϲ�ȣ 14�ڸ��� �Է��� �ּ���: ");
				vo.setRgnum(sc.nextLine());
				if (vo.getRgnum().length() != 14) {
					System.out.println("�Է� ����!");
					continue;
				} else {

					boolean check = vo.getRgnum().matches(regex);
					if (check == false) {
						System.out.println("�߸��� ������ �ֹε�Ϲ�ȣ �Դϴ�");
						continue;
					} else {
						result = true;
					}
					// Integer.parseInt(vo.getRgnum().substring(0, 6) + vo.getRgnum().substring(7));

					System.out.println();

				}
			} while (!result);
			tot = 0;

			for (i = 0; i < 12; i++) {

				if (i >= 6) {
					tot += chk[i] * Integer.parseInt(vo.getRgnum().substring(i + 1, i + 2));
				} else {
					tot += chk[i] * Integer.parseInt(vo.getRgnum().substring(i, i + 1));
				}
			}
			su = 11 - tot % 11;
			su = su % 10;

			if ((su == Integer.parseInt(vo.getRgnum().substring(13)))) {
				return;
			}

			System.out.println("�߸��� �ֹε�Ϲ�ȣ �Դϴ�. �ٽ� �Է��� �ּ���.");
		}

	}

	// ȸ������ - ��ȭ��ȣ �Է� �޼ҵ�
	public void inputPhone() {
		do {
			System.out.print("Ư������(-)�� ������ ��ȭ��ȣ�� �Է��� �ּ���: ");
			vo.setPhone(sc.nextLine());
			if ((vo.getPhone().length()) < 13 || (vo.getPhone().length()) > 13) {
				System.out.println("�Է� ����!");
				continue;
			} else {
				try {
					Integer.parseInt(
							vo.getPhone().substring(0, 3) + vo.getPhone().substring(4, 8) + vo.getPhone().substring(9));
				} catch (Exception e) {
					System.out.println("���ڸ� �Է��� �ּ���.");
					continue;
				}
			}
			// break;

		} while ((vo.getPhone().length()) != 13);
	}

	// ȸ��Ż��
	public void deleteId(String id) { // �α��� �� id

		Scanner sc = new Scanner(System.in);

		Iterator<PersonVO> it = lists.iterator();

		while (it.hasNext()) {

			vo = it.next();

			if (id.equals(vo.getId())) {

				int num;

				do {
					System.out.print("���� Ȯ���� ���� ��й�ȣ�� �Է��� �ּ���: ");
					String pw = (sc.nextLine());
					if (!vo.getPw().equals(pw)) {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է��� �ּ���.");
						continue;
					} else {
						try {
							System.out.print("ȸ�� Ż�� �����Ͻðڽ��ϱ�? [1.Yes 2.No]");
							num = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("���ڸ� �Է��� �ּ���.");
							continue;
						}

					}

					switch (num) {

					case 1:
						lists.remove(vo);
						System.out.println("[ " + id + " ] ������ �����Ǿ����ϴ�.");
						return;

					case 2:
						break;
					}

				} while (true);
			}
		}
	}

	// ȸ����������
		public void modify(String id) { // �α��� �� id

			String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";// ��ȭ��ȣ Ȯ�� ����ȭǥ����
			while (true) {

				Iterator<PersonVO> it = lists.iterator();

				while (it.hasNext()) {

					PersonVO vo = it.next();

					if (id.equals(vo.getId())) {

						System.out.print("���� Ȯ���� ���� ��й�ȣ�� �Է��� �ּ���: ");
						String pw = (sc.nextLine());

						if (vo.getPw().equals(pw)) {

							int num;
							boolean result = false;

							do {
								System.out.print("���Ͻô� �޴��� �Է��� �ּ���: ");
								System.out.print("1. ��й�ȣ ����	2. ��ȭ��ȣ ���� 3. ���� �޴���");
								num = Integer.parseInt(sc.nextLine());
							} while (num < 1);

							switch (num) {

							case 1:
								System.out.print("�����Ͻ� ��й�ȣ�� �Է��� �ּ���: ");
								vo.setPw(sc.nextLine());
								continue;

							case 2:
								do {
									System.out.print("�����Ͻ� ��ȭ��ȣ�� �Է��� �ּ���: ");
									vo.setPhone(sc.nextLine());

									boolean check = vo.getPhone().matches(regex);
									if (check == false) {
										System.out.println("�߸��� ������ ��ȭ��ȣ �Դϴ�");
										continue;
									} else {
										System.out.println("������ �Ϸ�Ǿ����ϴ�");
										result = true;
									}

								} while (!result);

							default:
								return;

							}
						}
					}
				}
				System.out.println("�߸��� ��й�ȣ�Դϴ� �ٽ� Ȯ�����ּ���");
			}

		}

	// �α���
	public String login() {

		String id;
		String pw;

		System.out.print("ID: ");
		id = sc.nextLine();
		System.out.print("��й�ȣ: ");
		pw = sc.nextLine();

		if (id.equals("admin") && pw.equals("admin")) {
			return "admin";
		}

		Iterator<PersonVO> it = lists.iterator();
		while (it.hasNext()) {
			PersonVO vo = it.next();

			if (id.equals(vo.getId()) && pw.equals(vo.getPw())) {
				System.out.println("�α��� ����!");
				return id;

			}
		}
		System.out.print("ID Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���. \n ");

		return "";

	}
}
