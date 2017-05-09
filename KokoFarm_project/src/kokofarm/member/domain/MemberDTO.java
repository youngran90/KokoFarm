package kokofarm.member.domain;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	private String member_id;
	private String member_password;
	private String member_name;
	private String member_email;
	private String member_phoneNum;
	private String member_zipcode;
	private String member_address1;
	private String member_address2;
	private String member_account;
	private String member_grade;
	private String join_date;
	private String cart_No;
	private String seller_no;
	
	public MemberDTO(String member_id, String member_password, String member_name, String member_email,
			String member_phoneNum, String member_zipcode, String member_address1, String member_address2,
			String member_account, String member_grade, String join_date, String cart_No, String seller_no) {
		super();
		this.member_id = member_id;
		this.member_password = member_password;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_phoneNum = member_phoneNum;
		this.member_zipcode = member_zipcode;
		this.member_address1 = member_address1;
		this.member_address2 = member_address2;
		this.member_account = member_account;
		this.member_grade = member_grade;
		this.join_date = join_date;
		this.cart_No = cart_No;
		this.seller_no = seller_no;
	}


	public MemberDTO(){
		
	}
	

	public String getSeller_no() {
		return seller_no;
	}


	public void setSeller_no(String seller_no) {
		this.seller_no = seller_no;
	}


	public void setCart_No(String cart_No) {
		this.cart_No = cart_No;
	}


	public String getCart_No() {
		return cart_No;
	}
	public void setCartNo(String cart_No) {
		this.cart_No = cart_No;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
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
	public String getMember_phoneNum() {
		return member_phoneNum;
	}
	public void setMember_phoneNum(String member_phoneNum) {
		this.member_phoneNum = member_phoneNum;
	}
	public String getMember_zipcode() {
		return member_zipcode;
	}
	public void setMember_zipcode(String member_zipcode) {
		this.member_zipcode = member_zipcode;
	}
	public String getMember_address1() {
		return member_address1;
	}
	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}
	public String getMember_address2() {
		return member_address2;
	}
	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
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
		return "MemberDTO [member_id=" + member_id + ", member_password=" + member_password + ", member_name="
				+ member_name + ", member_email=" + member_email + ", member_phoneNum=" + member_phoneNum
				+ ", member_zipcode=" + member_zipcode + ", member_address1=" + member_address1 + ", member_address2="
				+ member_address2 + ", member_account=" + member_account + ", member_grade=" + member_grade
				+ ", join_date=" + join_date + "]";
	}

	
	
	
}
