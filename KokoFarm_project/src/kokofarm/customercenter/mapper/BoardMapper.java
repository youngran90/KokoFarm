package kokofarm.customercenter.mapper;

import java.util.List;

import kokofarm.customercenter.model.Board;
import kokofarm.customercenter.model.Search;

public interface BoardMapper {
	int insertBoard(Board board);
	List<Board> listBoard(Search search);
	Board detailBoard(int seq);
	int updateBoard(Board board);
	int delete(Board board);
}


