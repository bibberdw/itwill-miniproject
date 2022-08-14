package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Person {

	Scanner sc = new Scanner(System.in);

	List<PersonVO> lists = new ArrayList<>();
	PersonVO vo;

	// 회원가입
	public void input() {
		vo = new PersonVO();

		inputId();
		inputPw();
		inputName();
		inputRgnum();
		inputPhone();

		lists.add(vo);
		System.out.println("회원가입이 완료되었습니다. 로그인 후 이용해 주시기 바랍니다.");

	}

	// 회원가입 - id 입력 메소드
	public void inputId() {
		boolean result2 = false;
		String id;

		do {
			System.out.print("ID를 입력해 주세요: ");
			id = sc.nextLine();

			if (id.equals("admin")) {
				System.out.println("관리자 ID로 생성할 수 없습니다. 다시 입력해 주세요.");
			} else {
				break;
			}

			Iterator<PersonVO> it = lists.iterator();

			while (it.hasNext()) {

				vo = it.next();

				if (id.equals(vo.getId())) {

					System.out.print("동일한 ID가 존재합니다. 다시 입력해 주세요.");
					continue;

				}
			}
		} while (!result2);

		vo.setId(id);
	}

	// 회원가입 - pw 입력 메소드
	public void inputPw() {

		String pw2;

		do {
			System.out.print("비밀번호를 입력해 주세요: ");
			vo.setPw(sc.nextLine());
			System.out.print("비밀번호 재확인을 위해 입력해 주세요: ");
			pw2 = sc.nextLine();

			if (pw2.equals(vo.getPw())) {
				break;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 재입력 해주세요.");
			}
		} while (!pw2.equals(vo.getPw()));
	}

	// 회원가입 - 이름 입력 메소드
	public void inputName() {
		System.out.print("이름을 입력해 주세요: ");
		vo.setName(sc.nextLine());
	}

	// 회원가입 - 주민등록번호 입력 메소드
	public void inputRgnum() {

		String regex = "^[0-9]{6}-[1234][0-9]{6}$"; // 주민번호 정규화 표현식

		int[] chk = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int i, tot, su = 0;
		boolean result = false;

		while (true) {
			do {
				System.out.print("특수문자(-)를 포함한 주민등록번호 14자리를 입력해 주세요: ");
				vo.setRgnum(sc.nextLine());
				if (vo.getRgnum().length() != 14) {
					System.out.println("입력 오류!");
					continue;
				} else {

					boolean check = vo.getRgnum().matches(regex);
					if (check == false) {
						System.out.println("잘못된 형식의 주민등록번호 입니다");
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

			System.out.println("잘못된 주민등록번호 입니다. 다시 입력해 주세요.");
		}

	}

	// 회원가입 - 전화번호 입력 메소드
	public void inputPhone() {
		do {
			System.out.print("특수문자(-)를 포함한 전화번호를 입력해 주세요: ");
			vo.setPhone(sc.nextLine());
			if ((vo.getPhone().length()) < 13 || (vo.getPhone().length()) > 13) {
				System.out.println("입력 오류!");
				continue;
			} else {
				try {
					Integer.parseInt(
							vo.getPhone().substring(0, 3) + vo.getPhone().substring(4, 8) + vo.getPhone().substring(9));
				} catch (Exception e) {
					System.out.println("숫자만 입력해 주세요.");
					continue;
				}
			}
			// break;

		} while ((vo.getPhone().length()) != 13);
	}

	// 회원탈퇴
	public void deleteId(String id) { // 로그인 시 id

		Scanner sc = new Scanner(System.in);

		Iterator<PersonVO> it = lists.iterator();

		while (it.hasNext()) {

			vo = it.next();

			if (id.equals(vo.getId())) {

				int num;

				do {
					System.out.print("정보 확인을 위해 비밀번호를 입력해 주세요: ");
					String pw = (sc.nextLine());
					if (!vo.getPw().equals(pw)) {
						System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
						continue;
					} else {
						try {
							System.out.print("회원 탈퇴를 진행하시겠습니까? [1.Yes 2.No]");
							num = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자만 입력해 주세요.");
							continue;
						}

					}

					switch (num) {

					case 1:
						lists.remove(vo);
						System.out.println("[ " + id + " ] 계정이 삭제되었습니다.");
						return;

					case 2:
						break;
					}

				} while (true);
			}
		}
	}

	// 회원정보수정
		public void modify(String id) { // 로그인 시 id

			String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";// 전화번호 확인 정규화표현식
			while (true) {

				Iterator<PersonVO> it = lists.iterator();

				while (it.hasNext()) {

					PersonVO vo = it.next();

					if (id.equals(vo.getId())) {

						System.out.print("정보 확인을 위해 비밀번호를 입력해 주세요: ");
						String pw = (sc.nextLine());

						if (vo.getPw().equals(pw)) {

							int num;
							boolean result = false;

							do {
								System.out.print("원하시는 메뉴를 입력해 주세요: ");
								System.out.print("1. 비밀번호 변경	2. 전화번호 변경 3. 메인 메뉴로");
								num = Integer.parseInt(sc.nextLine());
							} while (num < 1);

							switch (num) {

							case 1:
								System.out.print("변경하실 비밀번호를 입력해 주세요: ");
								vo.setPw(sc.nextLine());
								continue;

							case 2:
								do {
									System.out.print("변경하실 전화번호를 입력해 주세요: ");
									vo.setPhone(sc.nextLine());

									boolean check = vo.getPhone().matches(regex);
									if (check == false) {
										System.out.println("잘못된 형식의 전화번호 입니다");
										continue;
									} else {
										System.out.println("수정이 완료되었습니다");
										result = true;
									}

								} while (!result);

							default:
								return;

							}
						}
					}
				}
				System.out.println("잘못된 비밀번호입니다 다시 확인해주세요");
			}

		}

	// 로그인
	public String login() {

		String id;
		String pw;

		System.out.print("ID: ");
		id = sc.nextLine();
		System.out.print("비밀번호: ");
		pw = sc.nextLine();

		if (id.equals("admin") && pw.equals("admin")) {
			return "admin";
		}

		Iterator<PersonVO> it = lists.iterator();
		while (it.hasNext()) {
			PersonVO vo = it.next();

			if (id.equals(vo.getId()) && pw.equals(vo.getPw())) {
				System.out.println("로그인 성공!");
				return id;

			}
		}
		System.out.print("ID 혹은 비밀번호가 틀렸습니다. 다시 입력해 주세요. \n ");

		return "";

	}
}
