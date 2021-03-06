package kokofarm.orderproduct.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

public class OrderProductDTO implements Serializable{
	private String order_no; //주문번호	
	private String product_no; //제품번호
	private String member_id; //회원번호
	private String product_name; //제품명
	private int product_amount; // 수량
	private int product_price; //제품금액
	private int total_price; // 제품 총 금액(수량 * 금액)
	private int delivery_price; // 배송비
	private Timestamp order_date; // 주문일
	
	public OrderProductDTO() {
		super();
	}

	public OrderProductDTO(String order_no, String product_no, String member_id, String product_name,
			int product_amount, int product_price, int total_price, int delivery_price, Timestamp order_date) {
		super();
		this.order_no = order_no;
		this.product_no = product_no;
		this.member_id = member_id;
		this.product_name = product_name;
		this.product_amount = product_amount;
		this.product_price = product_price;
		this.total_price = total_price;
		this.delivery_price = delivery_price;
		this.order_date = order_date;
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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getDelivery_price() {
		return delivery_price;
	}

	public void setDelivery_price(int delivery_price) {
		this.delivery_price = delivery_price;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "OrderProductDTO [order_no=" + order_no + ", product_no=" + product_no + ", member_id=" + member_id
				+ ", product_name=" + product_name + ", product_amount=" + product_amount + ", product_price="
				+ product_price + ", total_price=" + total_price + ", delivery_price=" + delivery_price
				+ ", order_date=" + order_date + "]";
	}

	
	
	


}
