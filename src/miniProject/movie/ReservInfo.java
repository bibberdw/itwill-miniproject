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

	public void booking(Person person, MovieNow movieNow, String id) { // 예매

		// 회원정보 불러오기
		Iterator<PersonVO> PersonVOIt = person.lists.iterator();
		while (PersonVOIt.hasNext()) {
			personVO = PersonVOIt.next();
			if (personVO.getId().equals(id)) {
				break;
			}
		}

		movieNow.print(); // 상영영화 출력

		// 영화 선택
		boolean result = false;

		System.out.print("예매할 영화를 입력해주세요 ");
		String title = sc.nextLine();
		System.out.print("상영관을 선택해주세요 ");
		String screenID = sc.nextLine();
		System.out.print("회차을 선택해주세요 ");
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
			System.out.println("존재하지 않는 영화입니다.");
			return;
		}

		vo = new ReservInfoVO(personVO, movieNowVO);

		// 좌석 선택
		do {
			System.out.println();
			movieNow.printSeat();
			System.out.print("좌석을 입력해주세요[A1] ");
			String seat = sc.nextLine();
			int seatNum = 0;
			if (!(seat.charAt(0) >= 'A' && seat.charAt(0) <= 'J')) {
				System.out.println("잘못입력");
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
				System.out.println("잘못입력");
				continue;
			} else {
				seatNum += n - 1;
			}

			boolean[] seatNumTemp = movieNowVO.getSeatNum();
			if (seatNumTemp[seatNum]) {
				System.out.println("이미 예약된 좌석입니다.");
			}

			seatNumTemp[seatNum] = true;
			movieNowVO.setSeatNum(seatNumTemp);

			movieNow.seatUpdate(seat);
			vo.setSeat(seat);

		} while (vo.getSeat() == null);

		lists.add(vo);

	}

	public void cancelReserv(Person person, String id) { // 예매 취소

		// 회원정보 불러오기
		Iterator<PersonVO> PersonVOIt = person.lists.iterator();
		while (PersonVOIt.hasNext()) {
			personVO = PersonVOIt.next();
			if (personVO.getId().equals(id)) {
				break;
			}
		}

		// 예매취소
		Iterator<ReservInfoVO> it = lists.iterator();
		while (it.hasNext()) {
			vo = it.next();
			if (vo.getPersonVO().equals(personVO)) {
				System.out.println(vo.getMovieNowVO().toString());
				while (true) {
					System.out.print("취소하시겠습니까? [Y/N] ");
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
