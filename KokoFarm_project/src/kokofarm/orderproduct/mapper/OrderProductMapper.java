package kokofarm.orderproduct.mapper;

import java.util.List;
import java.util.Map;

import kokofarm.orderproduct.domain.OrderProductDTO;
import kokofarm.orderproduct.domain.OrderProductListDTO;


public interface OrderProductMapper {
	/*int ProductInsert(ProductDTO product);*/
	int Order(List<OrderProductDTO> checklist);
	List<OrderProductListDTO> OrderList(String member_id);
}
