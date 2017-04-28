package kokofarm.orderproduct.domain;

import java.io.Serializable;

//주문 내역 리스트 뷰에 출력하기 위한....
public class OrderProductListDTO implements Serializable{
	private String order_no; //주문번호 
	private String product_no; //제품번호
	private String product_name; //상품명
	//private String prodcut_imgsrc; //상품사진 경로
	//private int amount; //상품 수량
	private int product_price; //상품금액
	private int product_total; //상품 총 금액
	public OrderProductListDTO() {
		super();
	}
	public OrderProductListDTO(String order_no, String product_no, String product_name, /*String prodcut_imgsrc,
			int amount,*/ int product_price, int product_total) {
		super();
		this.order_no = order_no;
		this.product_no = product_no;
		this.product_name = product_name;
		//this.prodcut_imgsrc = prodcut_imgsrc;
	//	this.amount = amount;
		this.product_price = product_price;
		this.product_total = product_total;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/*public String getProdcut_imgsrc() {
		return prodcut_imgsrc;
	}
	public void setProdcut_imgsrc(String prodcut_imgsrc) {
		this.prodcut_imgsrc = prodcut_imgsrc;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}*/
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_total() {
		return product_total;
	}
	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}
	@Override
	public String toString() {
		return "OrderProductListDTO [order_no=" + order_no + ", product_no=" + product_no + ", product_name="
				+ product_name + ", product_price=" + product_price + ", product_total=" + product_total + "]";
	}
	
	
	
}
