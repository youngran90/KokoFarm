package kokofarm.member.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kokofarm.member.domain.ListModel;
import kokofarm.member.domain.MemberDTO;
import kokofarm.member.domain.MemberSearch;
import kokofarm.member.persistence.MemberDao;

public class MemberService {
	private static int PAGE_SIZE=5;

	private MemberService(){
		
	}
	private static class MemberServiceSingleton{
		private static final MemberService service = 
				new MemberService();
		private static MemberDao memberDao ;
		
	}
	
	public static MemberService getInstance(){
		System.out.println("Create service instance");
		MemberServiceSingleton.memberDao = MemberDao.getInstance();
		return MemberServiceSingleton.service;
	}
	
	
	public int insertMemberService(MemberDTO member) throws Exception {
		int re = MemberServiceSingleton.memberDao.insertMember(member);
		
		return re;
	}
	
	public boolean idcheckService(String userid) throws Exception{
		boolean result = MemberServiceSingleton.memberDao.idcheck(userid);
		return result;
	}

	public ListModel listJoinedMemberService(HttpServletRequest request, int requestPage) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		
		MemberSearch search = new MemberSearch();
		HttpSession session = request.getSession();
		
		String temp = request.getParameter("temp");
		
		if(temp!= null){
			session.removeAttribute("search");
			}
		
		if(request.getParameter("area") !=null){
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
			
			
		}else if((MemberSearch)session.getAttribute("search") !=null){
			search = (MemberSearch)session.getAttribute("search");
		}
			
		
		int totalMemberCount = MemberServiceSingleton.memberDao.countMember(search);
		int totalPageCount = totalMemberCount/PAGE_SIZE;	
		if (totalMemberCount%PAGE_SIZE >0){
			totalPageCount++;
		}
		
		int startPage = requestPage -(requestPage-1)%5;
		int endPage = startPage + 4;
		
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage-1)*PAGE_SIZE;
		
		List<MemberDTO> list = MemberServiceSingleton.memberDao.listJoinedMember(startRow, search);
		
		return new ListModel(list, requestPage, totalPageCount, startPage, endPage);
	}
	
	
	/*public boolean logincheckService(String member_id,String member_password) throws Exception{
		boolean result = MemberServiceSingleton.memberDao.logincheck(member_id,member_password);
		return result;
	}*/
	
}
