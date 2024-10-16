package dto;

public class EnrollmentDTO {
	private int num;
	private String EnrollmentDate;
	private String Enrollment;
	private String UserID;
	private String CourseID;
	private String Status;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(String enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	public String getEnrollment() {
		return Enrollment;
	}
	public void setEnrollment(String enrollment) {
		Enrollment = enrollment;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
