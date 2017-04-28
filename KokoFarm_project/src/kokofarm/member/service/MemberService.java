package kokofarm.member.service;

import java.util.List;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.domain.MemberSearch;
import kokofarm.member.persistence.MemberDao;

public class MemberService {

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

	public List<MemberDTO> listJoinedMemberService(MemberSearch search, int requestPage){
		List<MemberDTO> list = MemberServiceSingleton.memberDao.listJoinedMember(search);
		
		return list;
	}
	
	
	/*public boolean logincheckService(String member_id,String member_password) throws Exception{
		boolean result = MemberServiceSingleton.memberDao.logincheck(member_id,member_password);
		return result;
	}*/
	
}
