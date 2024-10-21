package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CourseDTO;

public class CourseDAO {
	
	private String username = "system";
	private String password = "11111111";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	public static CourseDAO coursedao = null;
//	PreparedStatement pstmt = null;
	
	
	private void CourseDAO() {
		init();
	}
	
	public static CourseDAO getInstance() {
		if(coursedao == null) {
			coursedao = new CourseDAO();
		}
		return coursedao;
	}
	

	private void init() { 
		try {
			Class.forName(driverName);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private boolean conn() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("커넥션 자원 획득 성공");
			return true; 
		} catch (Exception e) {
		}
		return false; 
	}
	public void insert(CourseDTO coursedto) {
		if(conn()) {
			try {
				String sql = "insert into Course values(Course_seq.nextval,?,?,?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, coursedto.getCourseID());
				psmt.setString(2, coursedto.getCourseName());
				psmt.setString(3, coursedto.getLanguage());
				psmt.setString(4, coursedto.getCourseType());
				psmt.setString(5, coursedto.getMoney());
				psmt.setString(6, coursedto.getRegion());
				int resultInt = psmt.executeUpdate();
				if(resultInt > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
				}
			}
		}
	}
	public void delete(String delNum) {
		if(conn()) {
			try {
				String sql ="delete from Course where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, delNum);
				psmt.executeUpdate();
			} catch (Exception e) {
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
				}
			}
		}
	}
	public void update(CourseDTO Cdto) {
		if(conn()) {
			try {
				String sql = "update Course set CourseID=?, CourseName=?, Language=?,"
						+ "CourseType=?, Money=?, Region=? Where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(7, Cdto.getNum());
				psmt.setString(1, Cdto.getCourseID());
				psmt.setString(2, Cdto.getCourseName()); 
				psmt.setString(3, Cdto.getLanguage());
				psmt.setString(4, Cdto.getCourseType());
				psmt.setString(5, Cdto.getMoney());
				psmt.setString(6, Cdto.getRegion());
				psmt.executeUpdate();
				conn.commit();
				if(psmt.executeUpdate() == 0) {
					System.out.println("존재하지 않습니다");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
				}
			}
		}
	}
	public ArrayList<CourseDTO> selectAll(){
		ArrayList<CourseDTO> clist = new ArrayList<>();
		if(conn()) {
			try {
				String sql = "select * from Course";
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()) {
					CourseDTO cTemp = new CourseDTO();
					cTemp.setNum(rs.getInt("num"));
					cTemp.setCourseID(rs.getString("CourseID"));
					cTemp.setCourseName(rs.getString("CourseName"));
					cTemp.setLanguage(rs.getString("Language"));
					cTemp.setCourseType(rs.getString("CourseType"));
					cTemp.setMoney(rs.getString("Money"));
					cTemp.setRegion(rs.getString("Region"));
					clist.add(cTemp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
				}
			}
		}
		return clist;
	}
	private CourseDTO select(int Cnum) {
		if(conn()) {
			try {
				String sql = "select * from Course where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, Cnum);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					CourseDTO cTemp = new CourseDTO();
					cTemp.setNum(rs.getInt("num"));
					cTemp.setCourseID(rs.getString("CourseID"));
					cTemp.setCourseName(rs.getString("CourseName"));
					cTemp.setLanguage(rs.getString("Language"));
					cTemp.setCourseType(rs.getString("CourseType"));
					cTemp.setMoney(rs.getString("Money"));
					cTemp.setRegion(rs.getString("Region"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
				}
			}
		}
		return null;
	}
}
