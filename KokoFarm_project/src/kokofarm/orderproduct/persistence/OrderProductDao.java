package kokofarm.orderproduct.persistence;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.cart.domain.ProductDTO;
import kokofarm.cart.mapper.CartMapper;
import kokofarm.orderproduct.domain.OrderProductDTO;
import kokofarm.orderproduct.domain.OrderProductListDTO;
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
	
	public int Order(List<OrderProductDTO> checklist){ // 리스트로 파라미터를 집어 넣는데 ..  xml에서는 객체로 받는다..???
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(OrderProductMapper.class).Order(checklist);
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
	
	public List<OrderProductListDTO> OrderList(String member_id){
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.getMapper(OrderProductMapper.class).OrderList(member_id);
		} catch (Exception e) {
			return null;
		}finally {
			session.close();
		}
		
	}


	/*public List<ProductDTO> ProductList(){
		SqlSession session = getSqlSessionFactory().openSession();
		
		try {
			return session.getMapper(CartMapper.class).ProductList();
		} catch (Exception e) {
			return null;
		}finally {
			session.close();
		}
	}*/
}

















