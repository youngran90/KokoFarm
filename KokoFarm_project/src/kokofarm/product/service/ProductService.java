package kokofarm.product.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kokofarm.product.domain.ListProductPage;
import kokofarm.product.domain.PostDTO;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.domain.ProductSearch;
import kokofarm.product.persistence.ProductDao;

public class ProductService {
	private static ProductService service = new ProductService();
	private static ProductDao productDao;
	private static final int  PAGE_SIZE = 6; //페이징 숫자 바꾸기
  
  public static ProductService getInstance(){
	  productDao = productDao.getInstance();
          return service;
  }
 //uuid생성
  public String create_UUID(){
      String uuid = UUID.randomUUID().toString().replace("-", "");
  return uuid;
}
 
  //상품등록
  public int insertProdectService(ProductDTO product){
	String uuid = create_UUID();
	product.setProduct_no("P-"+uuid);
	return  productDao.insertProcut(product);
  }
  
  //상품리스트, 페이징처리
  public ListProductPage listProductService(HttpServletRequest request, int requestPage){
	 HttpSession session = request.getSession();
	  String searchOption = request.getParameter("searchOption");
		String searchText = request.getParameter("searchText");
		
		System.out.println("searchOption : " + searchOption);
		System.out.println("searchText : " + searchText);
		
	 ProductSearch search = new ProductSearch();
	 
		if(searchOption != null && searchText != null){
			search.setSearchOption(searchOption);
			search.setSearchText("%"+searchText+"%");
			session.setAttribute("search", search);
			
		}
		
		/*else if((ProductSearch)session.getAttribute("search") != null){ //寃��깋 �썑 �럹�씠吏� 泥섎━ �겢由�
			search = (ProductSearch)session.getAttribute("search");
		}*/
		
		int totalCount = productDao.countProduct(search); 
		//총 상품갯수
		 int totalPageCount = totalCount / PAGE_SIZE ;  
		 if(totalCount%PAGE_SIZE > 0){ 
			 totalPageCount++; 
		 }
		 
		 int startPage = requestPage - (requestPage -1) % 5; 
		 int endPage = startPage + 4;
		 if(endPage > totalPageCount){
			 endPage = totalPageCount;
		 }
		 
		 int startRow = (requestPage-1) * PAGE_SIZE;
		 List<ProductDTO> list = productDao.listProduct(startRow, search);
	  
	  return new ListProductPage(list, requestPage, totalPageCount, startPage, endPage,searchOption,searchText );
  }

  //상품상세
  public ProductDTO detailProductService(String product_no){
	  return productDao.detailProduct(product_no);
  }

  
  //댓글 입력
  public int InsertPostService(PostDTO post){
	  String uuid = create_UUID();
		post.setPost_no("PO-"+uuid);
		System.out.println("InsertPostService OK");
		return  productDao.InsertPost(post);
  }
  
  public List<PostDTO> listPostService(String product_no){
	  return productDao.listPost(product_no);
  }

  //댓글삭제
  public int deletePostService(String post_no){
	  return productDao.deletePost(post_no);
  }
  
  //댓글수정
  public int updatePostService(PostDTO post){
	  return productDao.updatePost(post);
  }
  
  //cart productlist
  public List<ProductDTO> list_ProductService(){
	  return  productDao.list_Product();
  }
  
  
}
