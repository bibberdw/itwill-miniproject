package miniProject.movie;

public class ReservInfoVO {

	private PersonVO personVO; // ������
	private MovieNowVO movieNowVO; // �󿵿�ȭ����
	private String seat; // �¼�
	private String[] ticket;

	public ReservInfoVO(PersonVO personVO, MovieNowVO movieNowVO) {
		this.personVO = personVO;
		this.movieNowVO = movieNowVO;
	}

	public PersonVO getPersonVO() {
		return personVO;
	}

	public MovieNowVO getMovieNowVO() {
		return movieNowVO;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String[] getTicket() {
		return ticket;
	}

	public void setTicket() {
		String[] ticket = { //
				"========================================", //
				"", //
				"	  " + movieNowVO.getMovie().getTitle(), //
				"", //
				"	�󿵽ð� : " + movieNowVO.getStart() + "~" + movieNowVO.getFinish(), //
				"", //
				"		�󿵰� : " + movieNowVO.getScreenID(), //
				"", //
				"		�¼� : " + seat, //
				"", //
				"========================================" //
		};
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		String str = String.format("%s %s %s", personVO.getId(), movieNowVO.toString(), seat);
		return str;
	}
	
}
