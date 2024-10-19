package dto;

public class MemberDTO {
	private int Num;
	private String ID;
	private String Pwd;
	private String Name;
	private String Birth;
	private String Phone;
	
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "LoginDTO [Num=" + Num + ", ID=" + ID + ", Pwd=" + Pwd + ", Name=" + Name + ", Birth=" + Birth
				+ ", Phone=" + Phone + "]";
	}
}