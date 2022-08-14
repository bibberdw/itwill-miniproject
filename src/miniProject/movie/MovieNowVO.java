package miniProject.movie;

public class MovieNowVO {

	private MovieVO movie; // ��ȭ����
	private int round; // ȸ��
	private int start; // ���۽ð�
	private int finish; // ���ð�
	private String screenID; // �󿵰�ID
	private String[] poster;
	private boolean[] seatNum = new boolean[100];
	private String[] seat = { //
			"--------- screen -------", //
			"  1 2 3  4 5 6 7  8 9 10", //
			"A ���� ����� ����", //
			"B ���� ����� ����", //
			"C ���� ����� ����", //
			"D ���� ����� ����", //
			"E ���� ����� ����", //
			"F ���� ����� ����", //
			"G ���� ����� ����", //
			"H ���� ����� ����", //
			"I ���� ����� ����", //
			"J ���� ����� ����" //
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
				"	�󿵽ð� : " + start + "~" + finish, //
				"", //
				"		�󿵰� : " + screenID, //
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
		String str = String.format("%s %s�� %d ~ %d %dȸ��", movie.getTitle(), screenID, start, finish, round);
		return str;
	}

}
