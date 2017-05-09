package kokofarm.register.action;

public class ActionForward {
	private boolean isRedirect; //true=redirect //controller가 JSP를 찾을 때,
	private String path;
	
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
}
