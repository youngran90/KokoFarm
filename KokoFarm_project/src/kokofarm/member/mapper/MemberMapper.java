package kokofarm.member.mapper;

import java.util.List;
import java.util.Map;


import kokofarm.member.domain.MemberDTO;
import kokofarm.member.domain.MemberSearch;

public interface MemberMapper {
	
	public int insertMember(MemberDTO member);
	public int idcheck(String userid);
	public int logincheck(Map<String,String> map);
	public MemberDTO selectMember(String member_id);
	public List<MemberDTO> listJoinedMember(MemberSearch search);
	
	
}