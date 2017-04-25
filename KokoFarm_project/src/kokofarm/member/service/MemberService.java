package kokofarm.member.service;

import kokofarm.member.domain.MemberDTO;
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
	
}
