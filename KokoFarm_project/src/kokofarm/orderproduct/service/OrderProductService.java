package kokofarm.orderproduct.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kokofarm.cart.domain.ProductDTO;
import kokofarm.orderproduct.domain.OrderProductDTO;
import kokofarm.orderproduct.domain.OrderProductListDTO;
import kokofarm.orderproduct.persistence.OrderProductDao;

public class OrderProductService {
	private static OrderProductService service = new OrderProductService();
	private static OrderProductDao dao;
	private static int sum=0;
	private static int total=0;
	
	public static OrderProductService getInstance(){
		dao = OrderProductDao.getInstance();
		return service;
	}
	
	 public String create_UUID(){ //각 고유한 번호 생성 메소드
	      String uuid = UUID.randomUUID().toString().replace("-", "");
	  return uuid;
	}
	
	
	/*public int OrderProduct(String[] no, String member_id){
		OrderProductDTO orderproduct = new OrderProductDTO();
		//List<ProductDTO> list = dao.ProductList();
		List<OrderProductDTO> checklist = new ArrayList<OrderProductDTO>(); //체크한값을 저장하기 위한 리스트
				
		String order_no =  create_UUID();
		for (int i = 0; i < no.length; i++) { // no = 체크박스배열 list = 물품 객체
			for (int j = 0; j < list.size(); j++) {
				if (no[i].equals(list.get(j).getProduct_no())) {
					checklist
							.add(new OrderProductDTO(order_no, no[i], member_id, null, list.get(j).getProduct_price() ));
					// 주문번호 , 제품번호 , 회원번호, 주문일자, 제품가격
				}
			}
		}
		
	
		상품 총합 구하는 반복문
		  for(int i=0; i<list.size(); i++){
			if(list.get(i).getProduct_no().equals(no)){ // 상품번호로 금액 더한다.
				this.sum = list.get(i).getProduct_price();
				this.total += this.sum;
				orderproduct.setOrder_total(this.total);
			}
		}
		
	return dao.Order(checklist);
	}*/
	
	public List<OrderProductListDTO> OrderProductListDTO(String member_id){
		return dao.OrderList(member_id);
	}
	
	
}
