package kokofarm.orderproduct.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderProductDTO implements Serializable{
	private String order_no;
	private String product_no;
	private String member_id;
	private Timestamp order_date;
	private int order_total;
	
	public OrderProductDTO() {
		super();
	}

	public OrderProductDTO(String order_no, String product_no, String member_id, Timestamp order_date, int order_total) {
		super();
		this.order_no = order_no;
		this.product_no = product_no;
		this.member_id = member_id;
		this.order_date = order_date;
		this.order_total = order_total;
	}

	public int getOrder_total() {
		return order_total;
	}

	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getProduct_no() {
		return product_no;
	}

	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	
	
	
}
