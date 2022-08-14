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

		String loginId = ""; // 관리자 : admin/admin
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
			
			if (loginId == "") { // 로그아웃 상태
				do {
					System.out.println("");
					System.out.println("		┌──────────────┐\n");
					System.out.println("		   1.로그인 2.회원가입 3.종료\n   ");
					System.out.println("		└──────────────┘");
					System.out.println("· · · · · · · · · · · · · · · · · · · · · · \n");
					System.out.printf(" 메뉴 번호 : ");
					num = scanner();

				} while (num < 1 && num > 3);

				switch (num) {
				case 1:
					loginId = person.login(); // 로그인
					break;
				case 2:
					person.input(); // 회원가입
					break;
				case 3:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
			}

			if (loginId.equals("admin")) { // 관리자 상태
				do {
					System.out.println("");
					System.out.println("─────── ▷     M     E     N     U     ◁ ──────\n");
					System.out.println("  1.영화추가\t	2.영화수정\t	3.영화삭제\n   ");
					System.out.println("  4.상영추가\t	5.상영수정\t	6.상영취소\n   ");
					System.out.println("  7.로그아웃\n");
					System.out.println("───────────────────────────────\n");
					num = scanner();
				} while (num < 1 && num > 7);

				if ((num - 1) / 3 == 0)
					movie.print(); // 영화 출력
				else if ((num - 1) / 3 == 1)
					movieNow.print(); // 상영영화 출력

				switch (num) {
				case 1:
					movie.addMovie(); // 1.영화추가
					break;
				case 2:
					movie.modifyMovie(); // 2.영화수정
					break;
				case 3:
					movie.deleteMovie(); // 3.영화삭제
					break;
				case 4:
					movieNow.addMovieNow(movie); // 4.상영추가
					break;
				case 5:
					movieNow.modifyMovieNow(movie); // 5.상영수정
					break;
				case 6:
					movieNow.deleteMovieNow(movie); // 6.상영취소
					break;
				case 7:
					loginId = ""; // 7.로그아웃
					break;
				}

			} else if (!loginId.equals("")) { // 로그인 상태
				do {
					System.out.println("");
					movieNow.print(); // 상영영화 출력
					System.out.println("──────── ▷     M     E     N     U     ◁ ───────\n");
					System.out.println("   1.예매하기\t   	  2.예매취소\t	3.회원정보수정\n	");
					System.out.println("   4.탈퇴\t	  5.로그아웃	\n");
					System.out.println("─────────────────────────────────");
					System.out.println("· · · · · · · · · · · · · · · · · · · · · · \n");
					System.out.printf(" 메뉴 번호 : ");
					num = scanner();

				} while (num < 1 && num > 5);

				switch (num) {
				case 1:
					reservInfo.booking(person, movieNow, loginId); // 1.예매하기
					break;
				case 2:
					reservInfo.cancelReserv(person, loginId); // 2.예매취소
					break;
				case 3:
					person.modify(loginId); // 3.회원정보수정
					break;
				case 4:
					person.deleteId(loginId); // 4.탈퇴
				case 5:
					loginId = ""; // 5.로그아웃
					break;
				}

			}

		}
	}
}
