package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MemberDAO {
	private String username = "system";
	private String password = "11111111";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	private static MemberDAO memberdao = null;
	
	
	private void MemberDAO() {
		init();
	}
	
	public static MemberDAO getInstance() {
		if(memberdao == null) {
			memberdao = new MemberDAO();
		}
		return memberdao;
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
	public void insert(MemberDTO logindto) {
		if(conn()) {
			try {
				String sql = "insert into member values(member_seq.nextval,?,?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, logindto.getID());
				psmt.setString(2, logindto.getPwd());
				psmt.setString(3, logindto.getName());
				psmt.setString(4, logindto.getBirth());
				psmt.setString(5, logindto.getPhone());
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
	public void delete(String logNum) {
		if(conn()) {
			try {
				String sql = "delete from member where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, logNum);
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
	public void update(MemberDTO Ldto) {
		if(conn()) {
			try {
				String sql = "update member set ID=?, Password=? Where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(3, Ldto.getNum());
				psmt.setString(1, Ldto.getID());
				psmt.setString(2, Ldto.getPwd());
				psmt.executeUpdate();
				conn.commit();
				if(psmt.executeUpdate()==0) {
					System.out.println("존재하지 않습니다");
				}
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
	public ArrayList<MemberDTO> selectAll(){
		ArrayList<MemberDTO> jlist = new ArrayList<>();
		if(conn()) {
			try {
				String sql = "select * from member";
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()) {
					MemberDTO lTemp = new MemberDTO();
					lTemp.setNum(rs.getInt("Num"));
					lTemp.setID(rs.getString("ID"));
					lTemp.setPwd(rs.getString("Pwd"));
					lTemp.setName(rs.getString("Name"));
					lTemp.setBirth(rs.getString("Birth"));
					lTemp.setPhone(rs.getString("Phone"));
					jlist.add(lTemp);
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
		return jlist;
	}
	private MemberDTO select(int LNum) {
		if(conn()) {
			try {
				String sql = "select * from Login where num=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, LNum);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					MemberDTO lTemp = new MemberDTO();
					lTemp.setNum(rs.getInt("Num"));
					lTemp.setID(rs.getString("ID"));
					lTemp.setPwd(rs.getString("Pwd"));
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