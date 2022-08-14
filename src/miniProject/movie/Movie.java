package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Movie {
	List<MovieVO> lists = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	// ��ȭ ���� ���
	void addMovie() {

		MovieVO vo = new MovieVO();

		System.out.print("����� ��ȭ ������ �Է����ּ��� ");
		vo.setTitle(sc.nextLine());

		int num = 0;

		do {
			try {
				System.out.print("��ȭ�� ����Ÿ���� �Է����ּ��� ");
				vo.setRunTime(Integer.parseInt(sc.nextLine()));
				num++;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ��� ��) 120");
				num = 0;
			}
		} while (num == 0);

		System.out.print("������ ��θ� �Է����ּ��� ");
		vo.setPosterURL(sc.nextLine());

		System.out.print("��ȭ ���� ��¥�� �Է����ּ��� ");
		vo.setRelease(sc.nextLine());

		vo.setPoster();
		
		lists.add(vo);
		System.out.println(vo.getTitle() + "�� �߰��Ǿ����ϴ�\n");//�����߰�
		System.out.println(vo.toString());
	}

	// ��ȭ ����
	void deleteMovie() {

		while (true) {// ã�� ��ȭ�� ������ �ٽ�

			System.out.print("������ ��ȭ������ �Է��ϼ��� ");
			String title = sc.next();

			Iterator<MovieVO> it = lists.iterator();
			while (it.hasNext()) {

				MovieVO vo = it.next();

				if (title.equals(vo.getTitle())) {

					lists.remove(vo);
					System.out.println(vo.getTitle() + "�����Ϸ�");
					return;
				}

			}

			System.out.println("�������� �ʴ� ��ȭ�Դϴ�");
		}
	}

	void print() {

		Iterator<MovieVO> it = lists.iterator();
		while (it.hasNext()) {
			MovieVO vo = it.next();

			String[] str = vo.getPoster();

			try {
				for (int i = 0; i < str.length; i++) {
					System.out.println(str[i]);
				}
			} catch (Exception e) {
			}

		}

	}

	void printA() {
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).toString());
		}
	}

	// ��ȭ ���� ����
	void modifyMovie() {

		while (true) {
			System.out.print("������ ��ȭ������ �Է��ϼ��� ");// ������ �ٽ�
			String title = sc.nextLine();
			Iterator<MovieVO> it = lists.iterator();
			while (it.hasNext()) {

				MovieVO vo = it.next();

				if (title.equals(vo.getTitle())) {

					int num;
					int check = 0;
					while (true) {
						do {
							System.out.println("�����Ͻ� �׸��� �Է����ּ���");
							System.out.print("1. ��ȭ���� 2.����Ÿ�� 3.�����Ͱ�� 4.������¥ 5.�����Ϸ� ");
							num = Integer.parseInt(sc.nextLine());

						} while (num < 1);

						switch (num) {

						case 1:
							System.out.print("�����Ͻ� ��ȭ ������ �Է����ּ��� ");
							vo.setTitle(sc.nextLine());
							continue;

						case 2:
							do {
								try {
									System.out.print("��ȭ�� ����Ÿ���� �Է����ּ��� ");
									vo.setRunTime(Integer.parseInt(sc.nextLine()));
									check++;

								} catch (NumberFormatException e) {
									System.out.println("���ڸ� �Է����ּ��� ��) 120");
									check = 0;
								}
							} while (check == 0);
							check = 0;
							continue;
						case 3:
							System.out.print("������ ��θ� �Է����ּ��� ");
							vo.setPosterURL(sc.nextLine());
							continue;
						case 4:
							System.out.print("��ȭ ���� ��¥�� �Է����ּ��� ");
							vo.setRelease(sc.nextLine());
							continue;
						default:
							vo.setPoster();
							return;

						}

					}

				}

			}

			System.out.println("��ȭ�� �������� �ʽ��ϴ�");
		}

	}

}