package kokofarm.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.CartListDTO;
import kokofarm.cart.persistence.CartDAO;
import kokofarm.product.domain.ProductDTO;

public class CartService {
	public static CartService service = new CartService();
	public static CartDAO dao;
	
	public static CartService getInstance(){
		dao = CartDAO.getInstance();
		return service;
	}
	 public String create_UUID(){ //각 고유한 번호 생성 메소드
	      String uuid = UUID.randomUUID().toString().replace("-", "");
	  return uuid;
	}
	
	 /*public int insertList(ProductDTO product){
		return dao.product_insert(product);
	}*/
	 
	 public List<ProductDTO> product_list(){
		 return dao.product_list();
	 }
	 
	 public int cart_insert(CartDTO cart){
		 //장바구니에 담기
		 List<CartListDTO> list = service.cart_list(cart.getMember_id());
		 
		 if(list.size() !=0 ){
			 for(int i=0; i<list.size(); i++){
				 if(cart.getProduct_no().equals(list.get(i).getProduct_no())){
					 int amount = Integer.parseInt(list.get(i).getProduct_unit()); //저장된 수량
					 int update_amount = Integer.parseInt(cart.getProduct_unit()); //입력된 수량
					 String product_amount = amount+update_amount+"";
					 
					 System.out.println(amount+"@@@@@@@@@@@@@@");
					 System.out.println(update_amount+"@@@@@@@@@@@@@@");
					 System.out.println(product_amount+"@@@@@@@@@@@@@@");
					 
					 cart.setMember_id(cart.getMember_id());
					 cart.setProduct_unit(product_amount);
					 return dao.update(cart);
				 	}
				 break;
			 	}
			 return dao.cart(cart);
		}else{
			return dao.cart(cart);
		}
	 }
	 
	 public List<CartListDTO> cart_list(String member_id){
		 //장바구니 리스트 출력
		 return dao.cart_list(member_id);
	 }
	 
	 public int cart_delete(CartDTO cart_delete){ 
		 //선택한 항목만 삭제한다
		 return dao.cart_delete(cart_delete);
	 }
	 
	 public int cart_delte_all(CartDTO cart_delte_all){
		 // 장바구니 전체목록 삭제
		 return dao.cart_delte_all(cart_delte_all);
	 }
}
