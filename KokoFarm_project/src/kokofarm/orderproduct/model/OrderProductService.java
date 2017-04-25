package kokofarm.orderproduct.model;

import java.util.List;
import java.util.UUID;

public class OrderProductService {
	private static OrderProductService service = new OrderProductService();
	private static OrderProductDao dao;
	
	public static OrderProductService getInstance(){
		dao = OrderProductDao.getInstance();
		return service;
	}
	
	 public String create_UUID(){ //각 고유한 번호 생성 메소드
	      String uuid = UUID.randomUUID().toString().replace("-", "");
	  return uuid;
	}
	
	public int insertList(ProductDTO product){
		product.setProduct_no(create_UUID());
		return dao.ProductInsert(product);
	}
	
	public List<ProductDTO> Productlist(){
		return dao.ProductList();
	}
	
	public int OrderProduct(String no, String member_id){
		OrderProductDTO orderproduct = new OrderProductDTO();
		List<ProductDTO> list = dao.ProductList();
		int sum = 0;
		int total =0;
		orderproduct.setOrder_no(create_UUID()); //주문 번호
		orderproduct.setProduct_no(no); //상품 번호
		orderproduct.setMember_id(member_id); //멤버 아이디
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getProduct_no().equals(no)){
				sum = list.get(i).getProduct_price();
				sum++;
				System.out.println(sum);
			}
			
		}
		
		return dao.orderproduct(orderproduct);
	}
}
