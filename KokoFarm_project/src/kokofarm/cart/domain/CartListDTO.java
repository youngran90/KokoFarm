package kokofarm.cart.domain;

import java.io.Serializable;

public class CartListDTO implements Serializable{
	private String product_no;
	private String product_name;
	private int product_price;
	
	public CartListDTO() {
		super();
	}


	public CartListDTO(String product_no, String product_name, int product_price) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
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

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "CartListDTO [product_name=" + product_name + ", product_price=" + product_price + "]";
	}
	
	
	
}
