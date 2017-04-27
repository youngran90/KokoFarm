package kokofarm.member.mapper;

import java.util.Map;

import kokofarm.member.domain.MemberDTO;

public interface MemberMapper {
	
	public int insertMember(MemberDTO member);
	public int idcheck(String userid);
	public int logincheck(Map<String,String> map);
	public MemberDTO selectMember(String member_id);
}