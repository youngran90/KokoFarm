package kokofarm.product.action;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kokofarm.product.domain.ImageUtil;
import kokofarm.product.domain.ProductDTO;
import kokofarm.product.service.ProductService;

public class InsertProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = ProductService.getInstance();
		ProductDTO product = new ProductDTO();

		//String uploadPath = Application.getRealPath("ImageUpload");
		int size = 20 * 1024 * 1024; // 20MB
		String uploadPath = request.getRealPath("upload");
			
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8",
				new DefaultFileRenamePolicy());

		product.setProduct_name(multi.getParameter("product_name"));
		product.setProduct_unit(multi.getParameter("product_unit"));
		product.setProduct_price(Integer.parseInt(multi.getParameter("product_price")));
		product.setSeller_no(multi.getParameter("seller_no"));

		Enumeration files = multi.getFileNames();
		 
		
		String mainimage = (String)files.nextElement();
		String product_mainimage = multi.getFilesystemName(mainimage);
		System.out.println("1"+mainimage); //1sellerimage
		System.out.println("2"+product_mainimage);
		//217934376_441214739549616_2980281302797778944_n2.jpg
		
		String detailimage = (String)files.nextElement();
		String product_detailimage  = multi.getFilesystemName(detailimage);
		
		String sellerimage = (String)files.nextElement();
		String product_sellerimage  = multi.getFilesystemName(sellerimage);
		
		product.setProduct_mainimage(product_mainimage);
		product.setProduct_detailimage(product_detailimage);
		product.setProduct_sellerimage(product_sellerimage);
		
		/*if(detailimage == null){
			product.setProduct_detailimage("");
		}else if(sellerimage == null){
			product.setProduct_sellerimage("");

		}*/
		
		//작은 이미지 만들기
		if(multi.getFilesystemName("product_mainimage") != null){
			String pattern = product_mainimage.substring(product_mainimage.lastIndexOf(".")+1); //gif
			String headName = product_mainimage.substring(0, product_mainimage.lastIndexOf(".")); //aa
			
			
			String imagePath = uploadPath + "\\" + product_mainimage;
			File src = new File(imagePath); 
			System.out.println(imagePath);
			
			String thumImagePath = uploadPath + "\\" + headName + "_small" + pattern;
			File dest = new File(thumImagePath);
			System.out.println(thumImagePath);
		
			if(pattern.equals("jpg") || pattern.equals("gif")){
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			
        }
		
		
		service.insertProdectService(product);

		ActionForward forward = new ActionForward();
		forward.setRdirect(false);
		forward.setPath("list.jsp");

		return forward;
	}

}
