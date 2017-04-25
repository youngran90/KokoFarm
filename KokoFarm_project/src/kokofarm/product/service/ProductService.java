package kokofarm.product.service;

import java.util.UUID;

import kokofarm.product.domain.ProductDTO;
import kokofarm.product.persistence.ProductDao;

public class ProductService {
	private static ProductService service = new ProductService();
	private static ProductDao productDao;
  
  public static ProductService getInstance(){
	  productDao = productDao.getInstance();
          return service;
  }
  //dao 호출
  //페이징처리
  public String create_UUID(){
      String uuid = UUID.randomUUID().toString().replace("-", "");
  return uuid;
}
 
  public int insertProdectService(ProductDTO product){
	String uuid = create_UUID();
	product.setProduct_no(uuid);
	return  productDao.insertProcut(product);
  }

  
  
  
}
