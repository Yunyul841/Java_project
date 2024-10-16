package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UserDTO;

public class UserDAO {
	
	private String username = "system";
	private String password = "11111111";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	
	public static UserDAO studao = null;
	
	private void StuDAO() {
		init();
	}
	
	public static UserDAO getInstance() {
		if(studao == null) {
			studao = new UserDAO();
		}
		return studao;
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
	
	private void insert(UserDTO userdto) {
		if(conn()) {
			try {
				String sql = "insert into Stu_user values(wordlove_seq.nextval,?,?,?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, userdto.getUserID());
				psmt.setString(2, userdto.getPassword());
				psmt.setString(3, userdto.getName());
				psmt.setString(4, userdto.getPhone());
				psmt.setString(5, userdto.getEmail());
				psmt.setString(6, userdto.getJoinDate());		
				int resultInt = psmt.executeUpdate();
				if(resultInt > 0 ) {
					conn.commit();
				}else {
					conn.rollback();
				}
				
			} catch (SQLException e) {
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
	
	
	public void delete(int delNum) {
		if(conn()) {
			try {
				String sql ="delete from Stu_user where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, delNum);
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
	
	
	public void update(UserDTO udto) {
		if(conn()) {
			try {
				String sql = "update Stu_user set UserID=?, Password=?, Name=?, Phone=?, Email=? Where num = ?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(6, udto.getNum());
				psmt.setString(1, udto.getUserID());
				psmt.setString(2, udto.getPassword());
				psmt.setString(3, udto.getName());
				psmt.setString(4, udto.getPhone());
				psmt.setString(5, udto.getEmail());
				psmt.executeUpdate();
				conn.commit();
				if(psmt.executeUpdate() == 0) {
					System.out.println("존재하지 않습니다.");
				}
			} catch (SQLException e) {
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
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist = new ArrayList<UserDTO>();
		if(conn()) {
			try {
				String sql = "select * from Stu_user";
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				
				
				while(rs.next()) {
					UserDTO uTemp = new UserDTO();
					uTemp.setNum(rs.getInt("num"));
					uTemp.setEmail(rs.getString("Email"));
					uTemp.setJoinDate(rs.getString("joindate"));
					uTemp.setPassword(rs.getString("password"));
					uTemp.setName(rs.getString("name"));
					uTemp.setUserID(rs.getString("userid"));
					uTemp.setPhone(rs.getString("phone"));
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
		return ulist;
	}
}
	
	
	
	

