package kokofarm.register.mapper;

import java.util.List;

import kokofarm.register.model.RegDto;


public interface RegMapper {
	public int insert(RegDto regDto);
	public List<RegDto> regList();
	public RegDto regDetail(String auction_no);
	public int countBoard();
	public Integer selectAuction_no();

}
