package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//MovieVo movie//��ȭ����
//int //  ȸ��
//int // ���۽ð�
//int // ���ð�
//String // �󿵰�ID

public class MovieNow {
	List<MovieNowVO> lists = new ArrayList<>();

	MovieNowVO vo;
	MovieVO movieVO;
	Movie movie;

	Scanner sc = new Scanner(System.in);

	// �󿵿�ȭ ���� ���
	void addMovieNow(Movie movie) {
		int check = 0;
		boolean result = false;
		vo = new MovieNowVO();

		do {
			try {
				System.out.print("����� ��ȭ�� �Է����ּ��� ");
				String title = sc.nextLine();

				Iterator<MovieVO> it = movie.lists.iterator();

				while (it.hasNext()) {

					movieVO = it.next();

					if (title.equals(movieVO.getTitle())) {

						vo.setMovie(movieVO);
						result = true;
					}

				}
			} catch (Exception e1) {
				System.out.println("�������� �ʴ� ��ȭ�Դϴ�");
			}
		} while (!result);

		System.out.print("�󿵰� ID�� �Է����ּ��� ");
		vo.setScreenID(sc.nextLine());

		do {
			try {
				System.out.print("��ȭ�� ȸ���� �Է����ּ��� ");
				vo.setRound(Integer.parseInt(sc.nextLine()));

				if (vo.getRound() > 13 || vo.getRound() < 1) {
					System.out.println("ȸ���� 1ȸ~13ȸ���� �Է� �����մϴ�");
					continue;
				}
				check++;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���");
				check = 0;
			}
		} while (check == 0);

		// ��ȭ���۽ð� ����
		vo.setStart(8 + vo.getRound());// getRound��

		// ��ȭ�����½ð� ����
//		vo.setFinish(Integer.toString(Integer.parseInt(vo.getStart()) + vo.getMovie().getRunTime() / 60));
		vo.setFinish(vo.getStart() + vo.getMovie().getRunTime() / 60);

		lists.add(vo);

	}

	// �󿵿�ȭ ����
	void deleteMovieNow(Movie movie) {

		boolean result = false;
		int round = 0;

		while (true) {// ã�� ��ȭ�� ������ �ٽ�

			System.out.print("������ �󿵿�ȭ ������ �Է��ϼ��� ");
			String title = sc.nextLine();

			System.out.print("������ �󿵰�ID �Է��ϼ��� ");
			String screenID = sc.nextLine();

			do {
				try {
					System.out.print("������ ȸ���� �Է��ϼ��� ");
					round = Integer.parseInt(sc.nextLine());
					result = true;
				} catch (NumberFormatException e) {
					System.out.println("���ڸ� �Է����ּ���");
				}
			} while (!result);

			Iterator<MovieVO> it = movie.lists.iterator();
			while (it.hasNext()) {

				MovieVO movieVO = it.next();

				if (title.equals(movieVO.getTitle()) && screenID.equals(vo.getScreenID()) && round == vo.getRound()) {

					lists.remove(vo);
					System.out.println(movieVO.getTitle() + "�����Ϸ��߽��ϴ�");
					return;
				}

			}
			System.out.println("���ǿ� �´� �󿵿�ȭ�� �������� �ʽ��ϴ�");
		}

	}

	void print() {
		Iterator<MovieNowVO> it = lists.iterator();
		while (it.hasNext()) {
			vo = it.next();
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

	// �󿵿�ȭ ���� ����
	void modifyMovieNow(Movie movie) {

		boolean result = false;

		while (true) {// �˻� ���ǿ� ���� ������ �ٽ� �����մϴ�

			System.out.print("������ �󿵿�ȭ�� ������ �Է��ϼ��� ");
			String title = sc.nextLine();

			System.out.print("������ �󿵿�ȭ�� �󿵰�ID �Է��ϼ��� ");
			String screenID = sc.nextLine();

			int round = 0;
			do {
				try {
					System.out.print("������ �󿵿�ȭ�� ȸ���� �Է��ϼ��� ");
					round = Integer.parseInt(sc.nextLine());
					result = true;
				} catch (Exception e) {
					System.out.println("���ڸ� �Է� �����մϴ�");
				}
			} while (!result);
			result = false;// result �ʱ�ȭ

			Iterator<MovieNowVO> it = lists.iterator();
			while (it.hasNext()) {

				vo = it.next();

				if (title.equals(movieVO.getTitle()) && screenID.equals(vo.getScreenID()) && round == vo.getRound()) {

					int num;
					while (true) {
						do {
							System.out.println("�����Ͻ� �׸��� �Է����ּ���");
							System.out.print("1.ȸ�� 2.�󿵰�ID 3.�����Ϸ� ");
							num = Integer.parseInt(sc.nextLine());
						} while (num < 1);

						switch (num) {

						case 1:
							do {
								try {
									System.out.print("�����Ͻ� ȸ���� �Է����ּ��� ");
									vo.setRound(Integer.parseInt(sc.nextLine()));
									if (vo.getRound() > 13 || vo.getRound() < 1) {
										System.out.println("ȸ���� 1ȸ~13ȸ���� �Է� �����մϴ�");
										continue;
									} else {
										System.out.println("������ �Ϸ�Ǿ����ϴ�");
										System.out.println(vo.toString());
										result = true;
									}
								} catch (Exception e) {
									System.out.println("���ڸ� �Է� �����մϴ�");
								}
							} while (!result);
							result = false;// result �ʱ�ȭ

							// ��ȭ���۽ð� ����
							vo.setStart(8 + vo.getRound());
							// ��ȭ�����½ð� ����
							vo.setFinish(vo.getStart() + vo.getMovie().getRunTime() / 60);
							continue;
						case 2:
							System.out.print("�����Ͻ� �󿵰��� �Է����ּ��� ");
							vo.setScreenID(sc.nextLine());
							continue;
						default:
							vo.setPoster();
							return;

						}

					}

				}
			}
			System.out.println("���ǿ� �´� �󿵿�ȭ�� �������� �ʽ��ϴ�");
		}
	}

	void printSeat() { // �¼����
		String[] seat = vo.getSeat();
		for (int i = 0; i < seat.length; i++) {
			System.out.println(seat[i]);
		}
	}

	void seatUpdate(String seat) { // �¼� ���� ������Ʈ
		String[] seatTemp = vo.getSeat();

		char ch = (char) (seat.charAt(0) - 'A' + 2);
		int n = Integer.parseInt(seat.substring(1));
		if (n < 4)
			n += 2;
		else if (n < 8)
			n += 3;
		else
			n += 4;

		seatTemp[ch] = seatTemp[ch].substring(0, n - 1) + "��" + seatTemp[ch].substring(n);

		vo.setSeat(seatTemp);
	}
}