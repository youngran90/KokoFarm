package kokofarm.orderproduct.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kokofarm.orderproduct.domain.OrderProductDTO;
import kokofarm.orderproduct.domain.OrderProductListDTO;
import kokofarm.orderproduct.persistence.OrderProductDao;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.service.ProductService;

public class OrderProductService {
	private static OrderProductService service = new OrderProductService();
	private static ProductService service_product = ProductService.getInstance(); //영란이 누나꺼
	private static OrderProductDao dao;
	
	public static OrderProductService getInstance(){
		dao = OrderProductDao.getInstance();
		return service;
	}
	
	 public String create_UUID(){ //각 고유한 번호 생성 메소드
	      String uuid = UUID.randomUUID().toString().replace("-", "");
	  return uuid;
	}
	
	
	public int OrderProduct(String order_no,String[] product_no, String member_id, String[] product_amount, String[] total_price	){
		OrderProductDTO orderproduct = new OrderProductDTO();
		List<ProductDTO> list = service_product.list_ProductService(); 
		List<OrderProductDTO> checklist = new ArrayList<OrderProductDTO>(); //체크한값을 저장하기 위한 리스트
		List<OrderProductListDTO> orderlist = OrderProductListDTO(member_id);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).toString());
		}
		
		int delivery_price=0;
		
		if( orderlist.size()== 0){
			System.out.println("111111111111111");
			for (int i = 0; i < product_no.length; i++) { // product_no = 체크박스배열 / list = 물품 객체
				System.out.println("22222222222222222222");
				for (int j = 0; j < list.size(); j++) {
					if ( product_no[i].equals(list.get(j).getProduct_no())  ) { 
						if(list.get(j).getProduct_price() >= 100000){
							if(Integer.parseInt(total_price[i]) >= 500000){
								delivery_price = 0;
							}else{
								delivery_price = 10000;
							}
						}else if(list.get(j).getProduct_price() >= 10000){
							if(Integer.parseInt(total_price[i]) >= 50000){
								delivery_price = 0;
							}else{
								delivery_price = 5000;
							}
						}else if(list.get(j).getProduct_price() >= 0){
							if(Integer.parseInt(total_price[i]) >= 5000){
								delivery_price = 0;
							}else{
								delivery_price = 2500;
							}
						}
						
						checklist.add(new OrderProductDTO(
										order_no, //주문번호
										product_no[i], //제품번호
										member_id, //회원번호
										list.get(j).getProduct_name(), //제품명 
										Integer.parseInt(product_amount[i]), //수량
										list.get(j).getProduct_price(), //제품 금액 
										Integer.parseInt(total_price[i]), //제품 총 금액(수량*제품금액)
										delivery_price, //배송비
										null//주문일
										));
						// 주문번호 , 제품번호 , 회원번호, 제품명, 수량, 제품금액, 제품 총 금액, 배송비, 주문일
					} 
				}
			}
			return dao.Order(checklist);
		}else{
			checklist.clear();
			dao.deleteorder(member_id);
			for (int i = 0; i < product_no.length; i++) { // product_no = 체크박스배열 / list = 물품 객체
				for (int j = 0; j < list.size(); j++) {
					if ( product_no[i].equals(list.get(j).getProduct_no())  ) { 
						if(list.get(j).getProduct_price() >= 100000){
							if(Integer.parseInt(total_price[i]) >= 500000){
								delivery_price = 0;
							}else{
								delivery_price = 10000;
							}
						}else if(list.get(j).getProduct_price() >= 10000){
							if(Integer.parseInt(total_price[i]) >= 50000){
								delivery_price = 0;
							}else{
								delivery_price = 5000;
							}
						}else if(list.get(j).getProduct_price() >= 0){
							if(Integer.parseInt(total_price[i]) >= 5000){
								delivery_price = 0;
							}else{
								delivery_price = 2500;
							}
						}
						
						checklist.add(new OrderProductDTO(
										order_no, //주문번호
										product_no[i], //제품번호
										member_id, //회원번호
										list.get(j).getProduct_name(), //제품명 
										Integer.parseInt(product_amount[i]), //수량
										list.get(j).getProduct_price(), //제품 금액 
										Integer.parseInt(total_price[i]), //제품 총 금액(수량*제품금액)
										delivery_price, //배송비
										null//주문일
										));
						// 주문번호 , 제품번호 , 회원번호, 제품명, 수량, 제품금액, 제품 총 금액, 배송비, 주문일
					} 
				}
			}
			return dao.Order(checklist);
		}
		
	}
	
	public List<OrderProductListDTO> OrderProductListDTO(String member_id){
		return dao.OrderList(member_id);
	}
	
	
}
