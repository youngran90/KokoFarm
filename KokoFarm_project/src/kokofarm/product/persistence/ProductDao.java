package kokofarm.product.persistence;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.product.domain.PostDTO;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.domain.ProductSearch;
import kokofarm.product.mapper.ProductMapper;

public class ProductDao {
	
	private static ProductDao productdao = new ProductDao();

	public static ProductDao getInstance() {
			return productdao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//sql연결
	
	//상품등록
	public int insertProcut(ProductDTO product) {
		SqlSession seession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = seession.getMapper(ProductMapper.class).insertProdcut(product);
			if(re> 0){
				seession.commit();
			}else{
				seession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			seession.close();
		}
		
		return re;
	}

	public List<ProductDTO> listProduct(int startRow, ProductSearch search){
		SqlSession session = getSqlSessionFactory().openSession();
		List<ProductDTO> list = null;
		
		try {
			//페이지 숫자 바꾸기
			list = session.getMapper(ProductMapper.class).listProduct(new RowBounds(startRow, 2), search);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	public int countProduct(ProductSearch search){
		SqlSession session = getSqlSessionFactory().openSession();
		int rowNum = 0;
	 try {
		rowNum = session.getMapper(ProductMapper.class).countProduct(search);
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		session.close();
	}
		return rowNum;
	}
	
	//post
	public int InsertPost(PostDTO post){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(ProductMapper.class).InsertPost(post);
			if(re>0){
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public ProductDTO detailProduct(String product_no){
		SqlSession session = getSqlSessionFactory().openSession();
		ProductDTO product = new ProductDTO();
		
		return product = session.getMapper(ProductMapper.class).detailProduct(product_no);
	} 
		
}
