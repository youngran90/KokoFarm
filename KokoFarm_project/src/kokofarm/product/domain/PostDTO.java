package kokofarm.product.domain;

import com.sun.jmx.snmp.Timestamp;

public class PostDTO {
	
	private String product_no;
	private String post_no;
	private String member_id;
	private String post_content;
	private Timestamp post_date;
	
	public PostDTO(){}

	public PostDTO(String product_no, String post_no, String member_id, String post_content, Timestamp post_date) {
		super();
		this.product_no = product_no;
		this.post_no = post_no;
		this.member_id = member_id;
		this.post_content = post_content;
		this.post_date = post_date;
	}

	public String getProduct_no() {
		return product_no;
	}

	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}

	public String getPost_no() {
		return post_no;
	}

	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Timestamp getPost_date() {
		return post_date;
	}

	public void setPost_date(Timestamp post_date) {
		this.post_date = post_date;
	}

	
	
	

}
