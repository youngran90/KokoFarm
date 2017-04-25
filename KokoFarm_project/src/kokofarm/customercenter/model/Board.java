package kokofarm.customercenter.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable{

	public Board(){};
	
	private int seq;
	private String title;
	private String writer;
	private String contents;
	private Timestamp regdate;
	private int hitcount;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", regdate="
				+ regdate + ", hitcount=" + hitcount + "]";
	}
	
	
}
