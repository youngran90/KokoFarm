package kokofarm.customercenter.domain;

import java.io.Serializable;

public class BoardDTO implements Serializable{

	public BoardDTO(){};
	
	private int customer_no;
	private String customer_title;
	private String member_id;
	private String customer_content;
	private String customer_date;
	private int customer_hitcount;
	private int customer_ref;
	private int customer_step;
	private int customer_level;
	private String customer_fname;
	private String customer_pwd;
	
	
	public BoardDTO(int customer_no, String customer_title, String member_id, String customer_content,
			String customer_date, int customer_hitcount, int customer_ref, int customer_step, int customer_level,
			String customer_fname, String customer_pwd) {
		super();
		this.customer_no = customer_no;
		this.customer_title = customer_title;
		this.member_id = member_id;
		this.customer_content = customer_content;
		this.customer_date = customer_date;
		this.customer_hitcount = customer_hitcount;
		this.customer_ref = customer_ref;
		this.customer_step = customer_step;
		this.customer_level = customer_level;
		this.customer_fname = customer_fname;
		this.customer_pwd = customer_pwd;
	}


	public int getCustomer_no() {
		return customer_no;
	}


	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}


	public String getCustomer_title() {
		return customer_title;
	}


	public void setCustomer_title(String customer_title) {
		this.customer_title = customer_title;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getCustomer_content() {
		return customer_content;
	}


	public void setCustomer_content(String customer_content) {
		this.customer_content = customer_content;
	}


	public String getCustomer_date() {
		return customer_date;
	}


	public void setCustomer_date(String customer_date) {
		this.customer_date = customer_date;
	}


	public int getCustomer_hitcount() {
		return customer_hitcount;
	}


	public void setCustomer_hitcount(int customer_hitcount) {
		this.customer_hitcount = customer_hitcount;
	}


	public int getCustomer_ref() {
		return customer_ref;
	}


	public void setCustomer_ref(int customer_ref) {
		this.customer_ref = customer_ref;
	}


	public int getCustomer_step() {
		return customer_step;
	}


	public void setCustomer_step(int customer_step) {
		this.customer_step = customer_step;
	}


	public int getCustomer_level() {
		return customer_level;
	}


	public void setCustomer_level(int customer_level) {
		this.customer_level = customer_level;
	}


	public String getCustomer_fname() {
		return customer_fname;
	}


	public void setCustomer_fname(String customer_fname) {
		this.customer_fname = customer_fname;
	}


	public String getCustomer_pwd() {
		return customer_pwd;
	}


	public void setCustomer_pwd(String customer_pwd) {
		this.customer_pwd = customer_pwd;
	}


	@Override
	public String toString() {
		return "BoardDTO [customer_no=" + customer_no + ", customer_title=" + customer_title + ", member_id="
				+ member_id + ", customer_content=" + customer_content + ", customer_date=" + customer_date
				+ ", customer_hitcount=" + customer_hitcount + ", customer_ref=" + customer_ref + ", customer_step="
				+ customer_step + ", customer_level=" + customer_level + ", customer_fname=" + customer_fname
				+ ", customer_pwd=" + customer_pwd + "]";
	}
	
	
	
}