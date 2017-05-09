package kokofarm.customercenter.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import kokofarm.customercenter.domain.BoardDTO;
import kokofarm.customercenter.domain.SearchCustomer;


public interface BoardMapper {
	public int insertBoard(BoardDTO boarddto);	
	public Integer selectcustomer_no();	//댓글
	public List<BoardDTO> listBoard(RowBounds row, SearchCustomer searchCustomer);	//리스트+검색 + 페이징
	public BoardDTO selectBoard(int customer_no);					//1개글 선택
	public int updatecustomer_hitcount(BoardDTO boarddto);		//조회수
	
	public int updateStep(Map<String, Integer>map);				//댓글(그룹내순서)
	public int updateBoard(BoardDTO boarddto);
	public int delete(BoardDTO boarddto);
	
	public BoardDTO detailBoard(int customer_no);
	public int countBoard(BoardDTO boardDTO);						
	public int countBoard(SearchCustomer searchCustomer);	//검색한 애들 페이징처리
	
	
}


