package kokofarm.product.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.multi.MultiListUI;

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
		//String uploadPath = request.getRealPath("upload");
		String uploadPath = "C:\\Users\\youngran\\git\\KokoFarm_Project1\\KokoFarm_project\\WebContent\\upload";
		System.out.println(uploadPath);
	   
		 File file = new File(uploadPath);
	        //!표를 붙여주어 파일이 존재하지 않는 경우의 조건을 걸어줌
	        if(!file.exists()){
	            //디렉토리 생성 메서드
	            file.mkdirs();
	            System.out.println("created directory successfully!");
	        }

		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8",
				new DefaultFileRenamePolicy());

		product.setProduct_name(multi.getParameter("product_name"));
		product.setProduct_unit(multi.getParameter("product_unit"));
		product.setProduct_price(Integer.parseInt(multi.getParameter("product_price")));
		product.setSeller_no(multi.getParameter("seller_no"));
		System.out.println("날짜"+multi.getParameter("product_harvestdate"));

		Enumeration files = multi.getFileNames();
		 
		//서브
		String file1 = (String)files.nextElement();
		String Name1 = multi.getFilesystemName(file1);
		System.out.println("1"+file1); //1sellerimage
		System.out.println("2"+Name1);
		//217934376_441214739549616_2980281302797778944_n2.jpg
	
		String file2 = (String)files.nextElement();
		String Name2  = multi.getFilesystemName(file2);
		System.out.println("파일2"+file2);
		System.out.println("네임2"+Name2);
		
		String file3 = (String)files.nextElement();
		String Name3  = multi.getFilesystemName(file3);
		System.out.println();
		
		product.setProduct_mainimage(Name3);
		product.setProduct_detailimage(Name1);
		product.setProduct_sellerimage(Name2);
		
		if(file2 == null){
			product.setProduct_sellerimage("");
		}else if(file1 == null){
			product.setProduct_mainimage("");

		}
		
		//작은 이미지 만들기
		if(Name3 != null){
			String pattern = Name3.substring(Name3.lastIndexOf(".")+1); //gif
			System.out.println("pattern"+ pattern);
			
			
			String imagePath = uploadPath + "\\" + Name3;
			File src = new File(imagePath); 
			System.out.println("imagePath"+imagePath);
			
			String thumImagePath = uploadPath + "\\small_" + Name3;
			File dest = new File(thumImagePath);
			System.out.println("thumImagePath"+thumImagePath);
		
			if(pattern.equals("jpg") || pattern.equals("gif")){
				ImageUtil.resize(src, dest, 300, ImageUtil.RATIO);
			}
			
        }
				
		service.insertProdectService(product);

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("listproductAction.product");
		System.out.println("list로 넘어간다");
	
		return forward;
	}

}
