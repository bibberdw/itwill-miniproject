package miniProject.movie;

public class MovieVO {

	private String title; // ��ȭ����
	private int runTime; // ����Ÿ��
	private String posterURL; // ������ ���
	private String release; // ��ȭ������¥
	private String[] poster;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String[] getPoster() {
		return poster;
	}

	public void setPoster() {
		String[] poster = { //
				"========================================", //
				"", //
				"	  " + title, //
				"", //
				"	  ����Ÿ�� : " + runTime + "��", //
				"", //
				" ������ : https://www." + posterURL + ".com", //
				"", //
				"	������ : " + release, //
				"", //
				"========================================" //
		};
		this.poster = poster;
	}

	@Override
	public String toString() {

		String str = String.format("%6s %4d %6s %4s", title, runTime, posterURL, release);

		return str;
	}

}
