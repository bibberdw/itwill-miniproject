package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReservInfo {

	Scanner sc = new Scanner(System.in);

	List<ReservInfoVO> lists = new ArrayList<>();
	ReservInfoVO vo;
	Person person;
	PersonVO personVO;
	MovieNow movieNow;
	MovieNowVO movieNowVO;

	public void booking(Person person, MovieNow movieNow, String id) { // ����

		// ȸ������ �ҷ�����
		Iterator<PersonVO> PersonVOIt = person.lists.iterator();
		while (PersonVOIt.hasNext()) {
			personVO = PersonVOIt.next();
			if (personVO.getId().equals(id)) {
				break;
			}
		}

		movieNow.print(); // �󿵿�ȭ ���

		// ��ȭ ����
		boolean result = false;

		System.out.print("������ ��ȭ�� �Է����ּ��� ");
		String title = sc.nextLine();
		System.out.print("�󿵰��� �������ּ��� ");
		String screenID = sc.nextLine();
		System.out.print("ȸ���� �������ּ��� ");
		int round = 0;
		try {
			round = Integer.parseInt(sc.nextLine());
		} catch (Exception e1) {
		}

		Iterator<MovieNowVO> movieNowVOIt = movieNow.lists.iterator();
		while (movieNowVOIt.hasNext()) {
			movieNowVO = movieNowVOIt.next();
			if (movieNowVO.getMovie().getTitle().equals(title) && movieNowVO.getScreenID().equals(screenID)
					&& movieNowVO.getRound() == round) {
				result = true;
				break;
			}
		}

		if (!result) {
			System.out.println("�������� �ʴ� ��ȭ�Դϴ�.");
			return;
		}

		vo = new ReservInfoVO(personVO, movieNowVO);

		// �¼� ����
		do {
			System.out.println();
			movieNow.printSeat();
			System.out.print("�¼��� �Է����ּ���[A1] ");
			String seat = sc.nextLine();
			int seatNum = 0;
			if (!(seat.charAt(0) >= 'A' && seat.charAt(0) <= 'J')) {
				System.out.println("�߸��Է�");
				continue;
			} else {
				seatNum += (int) (seat.charAt(0) - 'A') * 10;
			}
			int n;
			try {
				n = Integer.parseInt(seat.substring(1));
			} catch (Exception e) {
				n = 0;
			}
			if (!(n > 0 && n <= 10)) {
				System.out.println("�߸��Է�");
				continue;
			} else {
				seatNum += n - 1;
			}

			boolean[] seatNumTemp = movieNowVO.getSeatNum();
			if (seatNumTemp[seatNum]) {
				System.out.println("�̹� ����� �¼��Դϴ�.");
			}

			seatNumTemp[seatNum] = true;
			movieNowVO.setSeatNum(seatNumTemp);

			movieNow.seatUpdate(seat);
			vo.setSeat(seat);

		} while (vo.getSeat() == null);

		lists.add(vo);

	}

	public void cancelReserv(Person person, String id) { // ���� ���

		// ȸ������ �ҷ�����
		Iterator<PersonVO> PersonVOIt = person.lists.iterator();
		while (PersonVOIt.hasNext()) {
			personVO = PersonVOIt.next();
			if (personVO.getId().equals(id)) {
				break;
			}
		}

		// �������
		Iterator<ReservInfoVO> it = lists.iterator();
		while (it.hasNext()) {
			vo = it.next();
			if (vo.getPersonVO().equals(personVO)) {
				System.out.println(vo.getMovieNowVO().toString());
				while (true) {
					System.out.print("����Ͻðڽ��ϱ�? [Y/N] ");
					String s = sc.nextLine();
					if (s.equals("Y") || s.equals("y")) {
						lists.remove(vo);
						return;
					} else if (s.equals("N") || s.equals("n")) {
						return;
					}
				}
			}
		}

	}

}
