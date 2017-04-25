package kokofarm.product.persistence;

import java.io.InputStream;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.product.domain.ProductDTO;
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
			re = seession.getMapper(ProductMapper.class).insertProcut(product);
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

		
	
		
}
