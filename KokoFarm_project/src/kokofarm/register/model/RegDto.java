package kokofarm.register.model;

import java.io.Serializable;

public class RegDto implements Serializable{
	private String auction_no;
	private String auction_name;
	private String seller_no;
	private String start_date;
	private String end_date;
	private int auction_up;
	private int auction_down;
	private String auction_content;
	private String auction_file;
	private String auction_detailImg;
	private String auction_detailImg2;
	
	public String getAuction_file() {
		return auction_file;
	}
	public void setAuction_file(String auction_file) {
		this.auction_file = auction_file;
	}
	public String getAuction_no() {
		return auction_no;
	}
	public void setAuction_no(String auction_no) {
		this.auction_no = auction_no;
	}
	public String getAuction_name() {
		return auction_name;
	}
	public void setAuction_name(String auction_name) {
		this.auction_name = auction_name;
	}
	public String getSeller_no() {
		return seller_no;
	}
	public void setSeller_no(String seller_no) {
		this.seller_no = seller_no;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getAuction_up() {
		return auction_up;
	}
	public void setAuction_up(int auction_up) {
		this.auction_up = auction_up;
	}
	public int getAuction_down() {
		return auction_down;
	}
	public void setAuction_down(int auction_down) {
		this.auction_down = auction_down;
	}
	public String getAuction_content() {
		return auction_content;
	}
	public void setAuction_content(String auction_content) {
		this.auction_content = auction_content;
	}
	
	public String getAuction_detailImg() {
		return auction_detailImg;
	}
	public void setAuction_detailImg(String auction_detailImg) {
		this.auction_detailImg = auction_detailImg;
	}
	public String getAuction_detailImg2() {
		return auction_detailImg2;
	}
	public void setAuction_detailImg2(String auction_detailImg2) {
		this.auction_detailImg2 = auction_detailImg2;
	}
	@Override
	public String toString() {
		return "RegDto [auction_no=" + auction_no + ", auction_name=" + auction_name + ", seller_no=" + seller_no
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", auction_up=" + auction_up
				+ ", auction_down=" + auction_down + ", auction_content=" + auction_content + ", auction_file="
				+ auction_file + ", auction_detailImg=" + auction_detailImg + ", auction_detailImg2="
				+ auction_detailImg2 + "]";
	}
	
	
	
	
	

	

	
	
}
