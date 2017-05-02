package kokofarm.product.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kokofarm.product.domain.PostDTO;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.domain.ProductSearch;

public interface ProductMapper {
 public int insertProdcut(ProductDTO product);
 public List<ProductDTO> listProduct(RowBounds row, ProductSearch search);
 public ProductDTO detailProduct(String product_no);
 public int countProduct(ProductSearch search);
 public int InsertPost(PostDTO post);
 public List<PostDTO> listPost(String product_no);
 public int deletePost(String post_no);
 public int updatePost(PostDTO post);
 }


