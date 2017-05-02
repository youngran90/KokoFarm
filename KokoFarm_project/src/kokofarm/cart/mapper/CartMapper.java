package kokofarm.cart.mapper;

import java.util.List;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.CartListDTO;
import kokofarm.cart.domain.ProductDTO;

public interface CartMapper {
	int product_insert(ProductDTO product);
	List<ProductDTO> product_list();
	int cart_insert(List<CartDTO> cart_list);
	List<CartListDTO> cart_list(String member_id);
	int cart_delete(CartDTO cart_delete);
	int cart_delte_all(CartDTO cart_delte_all);
}
