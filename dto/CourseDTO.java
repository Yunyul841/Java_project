package dto;

public class CourseDTO {
	private int num;
	private String Money;
	private String CouserID;
	private String CouserName;
	private String Language;
	private String CouserType;
	private String RegionID;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getMoney() {
		return Money;
	}
	public void setMoney(String money) {
		Money = money;
	}
	public String getCouserID() {
		return CouserID;
	}
	public void setCouserID(String couserID) {
		CouserID = couserID;
	}
	public String getCouserName() {
		return CouserName;
	}
	public void setCouserName(String couserName) {
		CouserName = couserName;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getCouserType() {
		return CouserType;
	}
	public void setCouserType(String couserType) {
		CouserType = couserType;
	}
	public String getRegionID() {
		return RegionID;
	}
	public void setRegionID(String regionID) {
		RegionID = regionID;
	}
}
