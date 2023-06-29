package movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import movie.dto.MovieDTO;
import movie.dto.ReserveDTO;
import movie.dto.UserDTO;


public class UserDAO {

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.104.105:1521:xe";
	String user="team2";
	String password="56789";
	
	Connection con=null; // DB연결
	PreparedStatement pt=null;//쿼리수행
	String sql=null;//쿼리저장
	ResultSet rs=null; // select 레코드검색후 저장

	public List<UserDTO> getidCheck(String user_id) {
		List<UserDTO> search = new ArrayList<>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="select user_id from userinfo where user_id=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, user_id);
			rs=pt.executeQuery();
			while(rs.next()) {
				UserDTO id = new UserDTO();
				id.setUser_id(rs.getString(1));

				search.add(id);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return search;
	}// 중복확인

	public int userSign(UserDTO userdto) {
		int result=0; 

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="insert into userinfo values(?,?,?,?,?,?)";
			pt=con.prepareStatement(sql);
			pt.setString(1, userdto.getUser_id());
			pt.setString(2, userdto.getUser_name());
			pt.setString(3, userdto.getUser_pwd());
			pt.setString(4, userdto.getUser_phone());
			pt.setString(5, userdto.getUser_email());
			pt.setString(6, userdto.getUser_gender());

			result=pt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return result;
	} // 회원가입

	public List<UserDTO> userLogin(String id, String pwd) {
		List<UserDTO> search = new ArrayList<>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="select User_ID,user_pwd from userinfo where User_ID=? and User_Pwd=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, id);
			pt.setString(2, pwd);
			rs=pt.executeQuery();
			while(rs.next()) {
				UserDTO login = new UserDTO();
				login.setUser_id(rs.getString(1));

				search.add(login);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return search;
	}// 로그인
	
	public List<UserDTO> getName(String user_id) {
		List<UserDTO> lst = new ArrayList<UserDTO>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select user_name from userinfo where user_id =?";
			pt=con.prepareStatement(sql);
			pt.setString(1, user_id);
			
			rs = pt.executeQuery();
			while(rs.next()) {
				UserDTO vo = new UserDTO();
				vo.setUser_name(rs.getString(1));
				
				lst.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return lst;
	} // 메인페이지 우측 상단 이름변화

	public List<MovieDTO> movieFind(String movie_name) {
		List<MovieDTO> search = new ArrayList<MovieDTO>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select movie_name from movie Where movie_name=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, movie_name);
			rs=pt.executeQuery();
			while(rs.next()) {
				MovieDTO findmov = new MovieDTO();
				findmov.setMovie_name(rs.getNString(1));
				
				search.add(findmov);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) pt.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return search;
	}// 메인페이지 검색기능

	public int booking(ReserveDTO reserve) {
		int result =-1;

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="insert into reserveuser values(?,?,?,?,?,?,?,sysdate)";
			pt=con.prepareStatement(sql);
			pt.setString(1, reserve.getUser_id());
			pt.setString(2, reserve.getMovie_name());
			pt.setString(3, reserve.getMovie_local());
			pt.setString(4, reserve.getSelect_day());
			pt.setString(5, reserve.getSelect_time());
			pt.setString(6, reserve.getPerson());
			pt.setString(7, reserve.getSetnumber());

			result=pt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		
		return result;
	}// 설정값


	public List<UserDTO> userIdFind(String name, String email) {
		List<UserDTO> search = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="select User_id from userinfo where User_name=? and User_email=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, name);
			pt.setString(2, email);
			rs=pt.executeQuery();
			while(rs.next()) {
				UserDTO idFind = new UserDTO();
				idFind.setUser_id(rs.getString(1));

				search.add(idFind);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return search;
	}//비번찾기

	public List<UserDTO> userPwFind(String name, String email, String id) {
		List<UserDTO> search = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="select User_pwd from userinfo where User_name=? and User_id=? and User_email=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, name);
			pt.setString(2, id);
			pt.setString(3, email);
			rs=pt.executeQuery();
			while(rs.next()) {
				UserDTO pwdFind = new UserDTO();
				pwdFind.setUser_pwd(rs.getString(1));

				search.add(pwdFind);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return search;
	}
	
	public List<ReserveDTO> getReceipt(String id) {
		List<ReserveDTO> search = new ArrayList<ReserveDTO>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select * from reserveuser Where user_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs=pt.executeQuery();
			while(rs.next()) {
				ReserveDTO vo = new ReserveDTO();
				vo.setMovie_name(rs.getString(2));
				vo.setSelect_time(rs.getString(5));
				vo.setReserve_date(rs.getString(8));
				vo.setSetnumber(rs.getString(7));
				vo.setPerson(rs.getString(6));
				vo.setMovie_local(rs.getString(3));
				vo.setSelect_day(rs.getString(4));
				search.add(vo);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) pt.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return search;
	}// 영수증 값

	public int delReserve(ReserveDTO deletedto) {
		int result =-1;

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="delete from reserveuser where user_id=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, deletedto.getUser_id());

			result=pt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return result;
	} // 예매취소

	public List<ReserveDTO> Chkreserve(String chkId) {
		List<ReserveDTO> check = new ArrayList<>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="select user_id from reserveuser where User_id=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, chkId);
			rs=pt.executeQuery();
			while(rs.next()) {
				ReserveDTO chkDTO = new ReserveDTO();
				chkDTO.setUser_id(rs.getString(1));

				check.add(chkDTO);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return check;
	} // 예매확인

	public List<UserDTO> mailSend(String emailFind) {
		List<UserDTO> result1 = new ArrayList<UserDTO>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select user_email,user_pwd,user_id from userinfo Where user_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, emailFind);
			rs=pt.executeQuery();
			while(rs.next()) {
				UserDTO vo = new UserDTO();
				vo.setUser_email(rs.getString(1));
				vo.setUser_pwd(rs.getString(2));
				vo.setUser_id(rs.getString(3));
				result1.add(vo);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) pt.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return result1;
	} //비밀번호 찾기 메일전송

	public int withdrawal(UserDTO withdrawaldto) {
		
		int result =-1;

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="delete from userinfo where user_id=? and user_pwd=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, withdrawaldto.getUser_id());
			pt.setString(2, withdrawaldto.getUser_pwd());

			result=pt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return result;
	} // 회원탈퇴
}
