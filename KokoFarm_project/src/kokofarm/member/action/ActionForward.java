package kokofarm.member.action;

public class ActionForward {

	private boolean isRdirect;
	private String path;
	
	public ActionForward(){};
	
	public ActionForward(boolean isRdirect, String path) {
		super();
		this.isRdirect = isRdirect;
		this.path = path;
	}

	public boolean isRdirect() {
		return isRdirect;
	}

	public void setRdirect(boolean isRdirect) {
		this.isRdirect = isRdirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}