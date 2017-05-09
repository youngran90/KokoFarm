package kokofarm.tender.persistence;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.tender.domain.AuctionDto;
import kokofarm.tender.domain.TenderDto;
import kokofarm.tender.mapper.AuctionMapper;

public class AuctionDao {
	private static AuctionDao dao= new AuctionDao();
	
	public static AuctionDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource= "mybatis-config_auction.xml";
		InputStream in=null;
		try {
			in= Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public void insertTender(TenderDto tender){
		SqlSession sqlSession= getSqlSessionFactory().openSession();
		int re=-1;
		try {
			re= sqlSession.getMapper(AuctionMapper.class).insertTender(tender);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AuctionDto selectAuctionProduct(String auction_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		return sqlSession.getMapper(AuctionMapper.class).selectAuctionProduct(auction_no);
	}
	
	public int selectCurrentPrice(String auction_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		if(sqlSession.getMapper(AuctionMapper.class).selectCurrentPrice(auction_no)==null){
			return 0;
		}else{
			return sqlSession.getMapper(AuctionMapper.class).selectCurrentPrice(auction_no);
		}
	}
	
	public TenderDto selectSuccess(String auction_no, int tender_price){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		return sqlSession.getMapper(AuctionMapper.class).selectSuccess(auction_no, tender_price);
	}
	
	public int selectPriceUp(String auction_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		return sqlSession.getMapper(AuctionMapper.class).selectPriceUp(auction_no);
	}
	
	public int selectPriceDown(String auction_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		return sqlSession.getMapper(AuctionMapper.class).selectPriceDown(auction_no);
	}
	
	public void updateTender(int tender_price){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re=-1;
		try {
			re=sqlSession.getMapper(AuctionMapper.class).updateTender(tender_price);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateAuctionResult(String auction_no){
		SqlSession sqlSession= getSqlSessionFactory().openSession();
		int re=-1;
		try {
			re=sqlSession.getMapper(AuctionMapper.class).updateAuctionResult(auction_no);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String selectSeller(String auction_no){
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		return sqlSession.getMapper(AuctionMapper.class).selectSeller(auction_no);
	}

}
