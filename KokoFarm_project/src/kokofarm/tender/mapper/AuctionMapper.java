package kokofarm.tender.mapper;

import org.apache.ibatis.annotations.Param;

import kokofarm.tender.domain.AuctionDto;
import kokofarm.tender.domain.TenderDto;

public interface AuctionMapper {
	public int insertTender(TenderDto tender);
	public AuctionDto selectAuctionProduct(String auction_no);
	public Integer selectCurrentPrice(String auction_no);
	//
	public TenderDto selectSuccess(@Param("a") String s, @Param("b") Integer i);
	public int selectPriceUp(String auction_no);
	public int selectPriceDown(String auction_no);
	public int updateTender(int tender_price);
	public int updateAuctionResult(String auction_no);
	public String selectSeller(String auction_no);
	

}
