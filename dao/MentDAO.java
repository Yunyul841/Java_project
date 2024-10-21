package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MentDTO;

public class MentDAO {
	private String username = "system";
	private String password = "11111111";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	public static MentDAO mentdao = null;
	
	private void MentDAO() {
		init();
	}
	
	public static MentDAO getInstance() {
		if(mentdao == null) {
			mentdao = new MentDAO();
		}
		return mentdao;
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
	
	public void insert(MentDTO mentdto)	{
		if(conn()) {
			try {
				String sql = "insert into Enrollment values(Enrollment_seq.nextval,?,?,default,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, mentdto.getUserID());
				psmt.setString(2, mentdto.getCourseID());
//				psmt.setString(3, mentdto.getEnrollmentDate());
				psmt.setString(3, mentdto.getStatus());
				int resultInt = psmt.executeUpdate();
				if(resultInt > 0 ) {
					conn.commit();
				}else {
					conn.rollback();
				}
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	public void delete(String delNum) {
		if(conn()) {
			try {
				String sql = "delete from Enrollment where num=? ";
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
					// TODO: handle exception
				}
			}
		}
	}
	public void update(MentDTO mdto) {
		if(conn()) {
			try {
				String sql = "update Enrollment set UserID=?, CourseID=?, EnrollmentDate=?,"
						+ " Status=? Where num=? ";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(5, mdto.getNum());
				psmt.setString(1, mdto.getUserID());
				psmt.setString(2, mdto.getCourseID());
				psmt.setString(3, mdto.getEnrollmentDate());
				psmt.setString(4, mdto.getStatus());
				if(psmt.executeUpdate() == 0) {
					System.out.println("존재하지 않습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	public ArrayList<MentDTO> selectAll(){
		ArrayList<MentDTO> mlist = new ArrayList<MentDTO>();
		if(conn()) {
			try {
				String sql = "select * from Enrollment";
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()) {
					MentDTO mTump = new MentDTO();
					mTump.setNum(rs.getInt("num"));
					mTump.setUserID(rs.getString("userid"));
					mTump.setCourseID(rs.getString("courseid"));
					mTump.setEnrollmentDate(rs.getString("enrollmentDate"));
					mTump.setStatus(rs.getString("status"));
					mlist.add(mTump);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}
		return mlist;
	}
	private MentDTO select(int findID) {
		if(conn()) {
			try {
				String sql = "select * from Enrollment where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, findID);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					MentDTO mTemp = new MentDTO();
					mTemp.setNum(rs.getInt("Num"));
					mTemp.setUserID(rs.getString("UserID"));
					mTemp.setCourseID(rs.getString("CourseID"));
					mTemp.setEnrollmentDate(rs.getString("EnrollmentDate"));
					mTemp.setStatus(rs.getString("Status"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
