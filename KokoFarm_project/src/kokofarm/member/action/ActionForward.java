package kokofarm.member.action;

public class ActionForward {
	private boolean isRedirect;  //
	private String path;  //어느페이지로 갈지 경로 설정
	
	public boolean isRedirect(){
		return isRedirect;
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}	
	/*private boolean isRedirect;
	private String path;
	
	public ActionForward(){};
	
	public ActionForward(boolean isRedirect, String path) {
		super();
		this.isRdirect = isRedirect;
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRdirect(boolean isRedirect) {
		this.isRdirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	*/
	
}