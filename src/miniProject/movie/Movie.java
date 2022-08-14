package miniProject.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Movie {
	List<MovieVO> lists = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	// 영화 정보 등록
	void addMovie() {

		MovieVO vo = new MovieVO();

		System.out.print("등록할 영화 제목을 입력해주세요 ");
		vo.setTitle(sc.nextLine());

		int num = 0;

		do {
			try {
				System.out.print("영화의 러닝타임을 입력해주세요 ");
				vo.setRunTime(Integer.parseInt(sc.nextLine()));
				num++;
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요 예) 120");
				num = 0;
			}
		} while (num == 0);

		System.out.print("포스터 경로를 입력해주세요 ");
		vo.setPosterURL(sc.nextLine());

		System.out.print("영화 개봉 날짜를 입력해주세요 ");
		vo.setRelease(sc.nextLine());

		vo.setPoster();
		
		lists.add(vo);
		System.out.println(vo.getTitle() + "이 추가되었습니다\n");//지금추가
		System.out.println(vo.toString());
	}

	// 영화 삭제
	void deleteMovie() {

		while (true) {// 찾는 영화가 없으면 다시

			System.out.print("삭제할 영화제목을 입력하세요 ");
			String title = sc.next();

			Iterator<MovieVO> it = lists.iterator();
			while (it.hasNext()) {

				MovieVO vo = it.next();

				if (title.equals(vo.getTitle())) {

					lists.remove(vo);
					System.out.println(vo.getTitle() + "삭제완료");
					return;
				}

			}

			System.out.println("존재하지 않는 영화입니다");
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

	// 영화 정보 수정
	void modifyMovie() {

		while (true) {
			System.out.print("수정할 영화제목을 입력하세요 ");// 없으면 다시
			String title = sc.nextLine();
			Iterator<MovieVO> it = lists.iterator();
			while (it.hasNext()) {

				MovieVO vo = it.next();

				if (title.equals(vo.getTitle())) {

					int num;
					int check = 0;
					while (true) {
						do {
							System.out.println("수정하실 항목을 입력해주세요");
							System.out.print("1. 영화제목 2.러닝타임 3.포스터경로 4.개봉날짜 5.수정완료 ");
							num = Integer.parseInt(sc.nextLine());

						} while (num < 1);

						switch (num) {

						case 1:
							System.out.print("수정하실 영화 제목을 입력해주세요 ");
							vo.setTitle(sc.nextLine());
							continue;

						case 2:
							do {
								try {
									System.out.print("영화의 러닝타임을 입력해주세요 ");
									vo.setRunTime(Integer.parseInt(sc.nextLine()));
									check++;

								} catch (NumberFormatException e) {
									System.out.println("숫자만 입력해주세요 예) 120");
									check = 0;
								}
							} while (check == 0);
							check = 0;
							continue;
						case 3:
							System.out.print("포스터 경로를 입력해주세요 ");
							vo.setPosterURL(sc.nextLine());
							continue;
						case 4:
							System.out.print("영화 개봉 날짜를 입력해주세요 ");
							vo.setRelease(sc.nextLine());
							continue;
						default:
							vo.setPoster();
							return;

						}

					}

				}

			}

			System.out.println("영화가 존재하지 않습니다");
		}

	}

}