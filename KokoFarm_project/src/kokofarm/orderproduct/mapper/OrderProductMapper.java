package kokofarm.orderproduct.mapper;

import java.util.List;

import kokofarm.orderproduct.model.OrderProductDTO;
import kokofarm.orderproduct.model.ProductDTO;


public interface OrderProductMapper {
	List<ProductDTO> ProductList();
	int ProductInsert(ProductDTO product);
	int OrderProduct(OrderProductDTO orderproduct);
}
