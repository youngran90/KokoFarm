package kokofarm.product.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductDTO implements Serializable{
	
	private String product_no;
	private String product_name;
	private String product_unit;	
	private int product_price;	
	private String seller_no;
	private Timestamp product_date;
	private int review_number;
	
	public ProductDTO(){}

	public ProductDTO(String product_no, String product_name, String product_unit, int product_price, String seller_no,
			Timestamp product_date, int review_number) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_unit = product_unit;
		this.product_price = product_price;
		this.seller_no = seller_no;
		this.product_date = product_date;
		this.review_number = review_number;
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

	public String getProduct_unit() {
		return product_unit;
	}

	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getSeller_no() {
		return seller_no;
	}

	public void setSeller_no(String seller_no) {
		this.seller_no = seller_no;
	}

	public Timestamp getProduct_date() {
		return product_date;
	}

	public void setProduct_date(Timestamp product_date) {
		this.product_date = product_date;
	}

	public int getReview_number() {
		return review_number;
	}

	public void setReview_number(int review_number) {
		this.review_number = review_number;
	}
	
	
}
	
