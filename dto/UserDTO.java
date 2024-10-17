package dto;

public class UserDTO {
	private int num;
	private String UserID;
	private String Password;
	private String Name;
	private String Phone;
	private String Email;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "UserDTO [num=" + num + ", UserID=" + UserID + ", Password=" + Password + ", Name=" + Name + ", Phone="
				+ Phone + ", Email=" + Email + "]";
	}
	
}
