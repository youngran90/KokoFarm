package kokofarm.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.sun.rowset.internal.Row;

import kokofarm.member.domain.MemberDTO;
import kokofarm.member.domain.MemberSearch;

public interface MemberMapper {
	
	
	public int insertMember(MemberDTO member);
	public int idcheck(String userid);
	public int logincheck(Map<String,String> map);
	public MemberDTO selectMember(String member_id);
	public List<MemberDTO> listJoinedMember(RowBounds row,MemberSearch search);
	public int countMember (MemberSearch search);
	
}