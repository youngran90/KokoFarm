package kokofarm.cart.persistence;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.ProductDTO;
import kokofarm.cart.mapper.CartMapper;

public class CartDAO {
	public static CartDAO dao = new CartDAO();
	
	public static CartDAO getInstance(){
		return dao;
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
	
	
	
	public int product_insert(ProductDTO product){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CartMapper.class).product_insert(product);
			if(re>0){
				session.commit();
			}else{
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	
	
	public List<ProductDTO> product_list(){
		SqlSession session = getSqlSessionFactory().openSession();
		
		try {
			return session.getMapper(CartMapper.class).product_list();
		} catch (Exception e) {
			return null;
		}finally {
			session.close();
		}
	}
	
	public int cart(List<CartDTO> cart_list){
		 for(int i=0; i<cart_list.size(); i++){
			 System.out.println(cart_list.get(i).toString());
		 }
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CartMapper.class).cart_insert(cart_list);
					if( re > 0 ){
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
	
	public List<ProductDTO> cart_list(String member_id){
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.getMapper(CartMapper.class).cart_list(member_id);
		} catch (Exception e) {
			return null;
		}finally {
			session.close();
		}
	}
	
	
	
	
}
