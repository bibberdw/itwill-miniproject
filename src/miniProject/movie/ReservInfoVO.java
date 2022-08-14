package miniProject.movie;

public class ReservInfoVO {

	private PersonVO personVO; // 고객정보
	private MovieNowVO movieNowVO; // 상영영화정보
	private String seat; // 좌석
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
				"	상영시간 : " + movieNowVO.getStart() + "~" + movieNowVO.getFinish(), //
				"", //
				"		상영관 : " + movieNowVO.getScreenID(), //
				"", //
				"		좌석 : " + seat, //
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
