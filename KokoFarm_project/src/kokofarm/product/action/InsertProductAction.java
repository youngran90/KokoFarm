package kokofarm.product.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
          //String uploadPath = "C:\\Users\\김Jason\\git\\KokoFarm_Project\\KokoFarm_project\\WebContent\\upload";
		 String uploadPath = "C:\\Users\\youngran\\git\\KokoFarm_Project2\\KokoFarm_project\\WebContent\\upload";

		//String uploadPath = "../WebContent/upload";
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
//		product.setSeller_no(multi.getParameter("seller_no"));
		
		//세션
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		System.out.println("member_id : "+ member_id);
		String seller_no = member_id;
		product.setSeller_no(seller_no);
		//product.setProduct_harvestdate(multi.getParameter("product_harvestdate"));
	
		System.out.println("날짜"+multi.getParameter("product_harvestdate"));
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
		Date date = format.parse(multi.getParameter("product_harvestdate"));
		product.setProduct_harvestdate(date);
		   
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
		
		if(Name2 == null || Name1 == null || Name3 == null){
			System.out.println("사진없음");
			 response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
            out.println("<script>alert('사진을 적어도 1장이상 등록하세요'); location.href='insert_product.jsp'; </script>");
			out.flush();
			out.close();
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
