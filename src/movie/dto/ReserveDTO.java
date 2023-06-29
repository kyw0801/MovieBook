package movie.dto;

public class ReserveDTO {
	private String user_id;
	private String movie_name;
	private String movie_local;
	private String select_day;
	private String select_time;
	private String person;
	private String setnumber;
	private String reserve_date;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_local() {
		return movie_local;
	}
	public void setMovie_local(String movie_local) {
		this.movie_local = movie_local;
	}
	public String getSelect_day() {
		return select_day;
	}
	public void setSelect_day(String select_day) {
		this.select_day = select_day;
	}
	public String getSelect_time() {
		return select_time;
	}
	public void setSelect_time(String select_time) {
		this.select_time = select_time;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getSetnumber() {
		return setnumber;
	}
	public void setSetnumber(String setnumber) {
		this.setnumber = setnumber;
	}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
	
	

}
