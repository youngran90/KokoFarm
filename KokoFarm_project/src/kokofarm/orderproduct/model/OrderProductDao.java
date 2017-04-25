package kokofarm.orderproduct.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.orderproduct.mapper.OrderProductMapper;


public class OrderProductDao {
	private static OrderProductDao dao = new OrderProductDao();
	public static OrderProductDao getInstance(){
		return dao;
	}
	
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try{
			in = Resources.getResourceAsStream(resource);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int ProductInsert(ProductDTO product){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(OrderProductMapper.class).ProductInsert(product);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return re;
	}
	
	public List<ProductDTO> ProductList(){
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.getMapper(OrderProductMapper.class).ProductList();
			
		} catch (Exception e) {
			return null;
		}finally {
			session.close();
		}
	}
	public int orderproduct(OrderProductDTO orderproduct){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(OrderProductMapper.class).OrderProduct(orderproduct);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
}

















