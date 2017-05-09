package kokofarm.cart.mapper;

import java.util.List;

import kokofarm.cart.domain.CartDTO;
import kokofarm.cart.domain.CartListDTO;
import kokofarm.product.domain.ProductDTO;

public interface CartMapper {
	/*int product_insert(ProductDTO product);*/
	List<ProductDTO> product_list();
	int cart_insert(CartDTO cart);
	List<CartListDTO> cart_list(String member_id);
	int cart_delete(CartDTO cart_delete);
	int cart_delte_all(CartDTO cart_delte_all);
	int cart_update(CartDTO cart);
}
