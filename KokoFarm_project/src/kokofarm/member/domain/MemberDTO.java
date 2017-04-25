package kokofarm.member.domain;

public class MemberDTO {
 
	private String member_id;
	private String member_name;
	private String member_email;
	private String member_password;
	private String member_phoneNum;
	private String member_address;
	private String member_account;
	private String member_grade;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_phoneNum() {
		return member_phoneNum;
	}
	public void setMember_phoneNum(String member_phoneNum) {
		this.member_phoneNum = member_phoneNum;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public String getMember_grade() {
		return member_grade;
	}
	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", member_name=" + member_name + ", member_email=" + member_email
				+ ", member_password=" + member_password + ", member_phoneNum=" + member_phoneNum + ", member_address="
				+ member_address + ", member_account=" + member_account + ", member_grade=" + member_grade + "]";
	}
	
	
}
