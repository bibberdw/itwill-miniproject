package miniProject.movie;

public class MovieNowVO {

	private MovieVO movie; // 영화정보
	private int round; // 회차
	private int start; // 시작시간
	private int finish; // 끝시간
	private String screenID; // 상영관ID
	private String[] poster;
	private boolean[] seatNum = new boolean[100];
	private String[] seat = { //
			"--------- screen -------", //
			"  1 2 3  4 5 6 7  8 9 10", //
			"A □□□ □□□□ □□□", //
			"B □□□ □□□□ □□□", //
			"C □□□ □□□□ □□□", //
			"D □□□ □□□□ □□□", //
			"E □□□ □□□□ □□□", //
			"F □□□ □□□□ □□□", //
			"G □□□ □□□□ □□□", //
			"H □□□ □□□□ □□□", //
			"I □□□ □□□□ □□□", //
			"J □□□ □□□□ □□□" //
	};

	public MovieVO getMovie() {
		return movie;
	}

	public void setMovie(MovieVO movie) {
		this.movie = movie;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public String getScreenID() {
		return screenID;
	}

	public void setScreenID(String screenID) {
		this.screenID = screenID;
	}

	public String[] getPoster() {
		return poster;
	}

	public void setPoster() {
		String[] poster = { //
				"========================================", //
				"", //
				"	  " + movie.getTitle(), //
				"", //
				"	상영시간 : " + start + "~" + finish, //
				"", //
				"		상영관 : " + screenID, //
				"", //
				"========================================" //
		};
		this.poster = poster;
	}

	public boolean[] getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(boolean[] seatNum) {
		this.seatNum = seatNum;
	}

	public String[] getSeat() {
		return seat;
	}

	public void setSeat(String[] seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		String str = String.format("%s %s관 %d ~ %d %d회차", movie.getTitle(), screenID, start, finish, round);
		return str;
	}

}
