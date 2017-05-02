package kokofarm.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.CartListDTO;
import kokofarm.cart.domain.ProductDTO;
import kokofarm.cart.persistence.CartDAO;

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
	
	 public int insertList(ProductDTO product){
		return dao.product_insert(product);
	}
	 
	 public List<ProductDTO> product_list(){
		 return dao.product_list();
	 }
	 
	 public int cart_insert(String[] checklist, String member_id){//체크한 품목들 장바구니 테이블에 저장하는 메소드
		 CartDTO cartDTO = new CartDTO();
		 List<ProductDTO> product_list = dao.product_list(); //제품 객체랑 비교
		 List<CartDTO> cart_list = new ArrayList<CartDTO>(); //장바구니 객체에 저장
		 
		 String cart_no = create_UUID();
		 for(int i=0; i<checklist.length; i++){
			 for(int j=0; j<product_list.size(); j++){
				 if(checklist[i].equals(product_list.get(j).getProduct_no())){
					 cart_list.add(new CartDTO(cart_no, product_list.get(j).getProduct_no(), member_id));
					 //장바구니 번호,  상품번호, 아이디 
				 }
			 }
		 }
		 /*for(int i=0; i<cart_list.size(); i++){
			 System.out.println(cart_list.get(i).toString());
		 }*/
		 return dao.cart(cart_list);
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
