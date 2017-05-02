package kokofarm.cart.persistence;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.CartListDTO;
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
	
	public List<CartListDTO> cart_list(String member_id){
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.getMapper(CartMapper.class).cart_list(member_id);
		} catch (Exception e) {
			return null;
		}finally {
			session.close();
		}		
	}
	
	public int cart_delete(CartDTO cart_delete){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CartMapper.class).cart_delete(cart_delete);
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
	
	public int cart_delte_all(CartDTO cart_delte_all){
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re =  session.getMapper(CartMapper.class).cart_delte_all(cart_delte_all);
			if( re> 0 ){
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
	
}
