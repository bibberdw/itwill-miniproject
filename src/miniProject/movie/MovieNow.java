package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//MovieVo movie//영화정보
//int //  회차
//int // 시작시간
//int // 끝시간
//String // 상영관ID

public class MovieNow {
	List<MovieNowVO> lists = new ArrayList<>();

	MovieNowVO vo;
	MovieVO movieVO;
	Movie movie;

	Scanner sc = new Scanner(System.in);

	// 상영영화 정보 등록
	void addMovieNow(Movie movie) {
		int check = 0;
		boolean result = false;
		vo = new MovieNowVO();

		do {
			try {
				System.out.print("등록할 영화를 입력해주세요 ");
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
				System.out.println("존재하지 않는 영화입니다");
			}
		} while (!result);

		System.out.print("상영관 ID를 입력해주세요 ");
		vo.setScreenID(sc.nextLine());

		do {
			try {
				System.out.print("영화의 회차를 입력해주세요 ");
				vo.setRound(Integer.parseInt(sc.nextLine()));

				if (vo.getRound() > 13 || vo.getRound() < 1) {
					System.out.println("회차는 1회~13회까지 입력 가능합니다");
					continue;
				}
				check++;
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요");
				check = 0;
			}
		} while (check == 0);

		// 영화시작시간 세팅
		vo.setStart(8 + vo.getRound());// getRound는

		// 영화끝나는시간 세팅
//		vo.setFinish(Integer.toString(Integer.parseInt(vo.getStart()) + vo.getMovie().getRunTime() / 60));
		vo.setFinish(vo.getStart() + vo.getMovie().getRunTime() / 60);

		lists.add(vo);

	}

	// 상영영화 삭제
	void deleteMovieNow(Movie movie) {

		boolean result = false;
		int round = 0;

		while (true) {// 찾는 영화가 없으면 다시

			System.out.print("삭제할 상영영화 제목을 입력하세요 ");
			String title = sc.nextLine();

			System.out.print("삭제할 상영관ID 입력하세요 ");
			String screenID = sc.nextLine();

			do {
				try {
					System.out.print("삭제할 회차를 입력하세요 ");
					round = Integer.parseInt(sc.nextLine());
					result = true;
				} catch (NumberFormatException e) {
					System.out.println("숫자만 입력해주세요");
				}
			} while (!result);

			Iterator<MovieVO> it = movie.lists.iterator();
			while (it.hasNext()) {

				MovieVO movieVO = it.next();

				if (title.equals(movieVO.getTitle()) && screenID.equals(vo.getScreenID()) && round == vo.getRound()) {

					lists.remove(vo);
					System.out.println(movieVO.getTitle() + "삭제완료했습니다");
					return;
				}

			}
			System.out.println("조건에 맞는 상영영화가 존재하지 않습니다");
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

	// 상영영화 정보 수정
	void modifyMovieNow(Movie movie) {

		boolean result = false;

		while (true) {// 검색 조건에 맞지 않으면 다시 실행합니다

			System.out.print("수정할 상영영화의 제목을 입력하세요 ");
			String title = sc.nextLine();

			System.out.print("수정할 상영영화의 상영관ID 입력하세요 ");
			String screenID = sc.nextLine();

			int round = 0;
			do {
				try {
					System.out.print("수정할 상영영화의 회차를 입력하세요 ");
					round = Integer.parseInt(sc.nextLine());
					result = true;
				} catch (Exception e) {
					System.out.println("숫자만 입력 가능합니다");
				}
			} while (!result);
			result = false;// result 초기화

			Iterator<MovieNowVO> it = lists.iterator();
			while (it.hasNext()) {

				vo = it.next();

				if (title.equals(movieVO.getTitle()) && screenID.equals(vo.getScreenID()) && round == vo.getRound()) {

					int num;
					while (true) {
						do {
							System.out.println("수정하실 항목을 입력해주세요");
							System.out.print("1.회차 2.상영관ID 3.수정완료 ");
							num = Integer.parseInt(sc.nextLine());
						} while (num < 1);

						switch (num) {

						case 1:
							do {
								try {
									System.out.print("수정하실 회차를 입력해주세요 ");
									vo.setRound(Integer.parseInt(sc.nextLine()));
									if (vo.getRound() > 13 || vo.getRound() < 1) {
										System.out.println("회차는 1회~13회까지 입력 가능합니다");
										continue;
									} else {
										System.out.println("수정이 완료되었습니다");
										System.out.println(vo.toString());
										result = true;
									}
								} catch (Exception e) {
									System.out.println("숫자만 입력 가능합니다");
								}
							} while (!result);
							result = false;// result 초기화

							// 영화시작시간 세팅
							vo.setStart(8 + vo.getRound());
							// 영화끝나는시간 세팅
							vo.setFinish(vo.getStart() + vo.getMovie().getRunTime() / 60);
							continue;
						case 2:
							System.out.print("수정하실 상영관을 입력해주세요 ");
							vo.setScreenID(sc.nextLine());
							continue;
						default:
							vo.setPoster();
							return;

						}

					}

				}
			}
			System.out.println("조건에 맞는 상영영화가 존재하지 않습니다");
		}
	}

	void printSeat() { // 좌석출력
		String[] seat = vo.getSeat();
		for (int i = 0; i < seat.length; i++) {
			System.out.println(seat[i]);
		}
	}

	void seatUpdate(String seat) { // 좌석 정보 업데이트
		String[] seatTemp = vo.getSeat();

		char ch = (char) (seat.charAt(0) - 'A' + 2);
		int n = Integer.parseInt(seat.substring(1));
		if (n < 4)
			n += 2;
		else if (n < 8)
			n += 3;
		else
			n += 4;

		seatTemp[ch] = seatTemp[ch].substring(0, n - 1) + "■" + seatTemp[ch].substring(n);

		vo.setSeat(seatTemp);
	}
}