package kokofarm.register.action;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kokofarm.register.action.ActionForward;
import kokofarm.register.model.ImageUtil;
import kokofarm.register.model.RegDao;
import kokofarm.register.model.RegDto;

public class RegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RegDao dao = RegDao.getInstance();
		RegDto regDto = new RegDto();
//		String str = request.getParameter("auction_name");
//		String str2 = request.getParameter("start_date");
//		String str3 = request.getParameter("end_date");
//		int price = Integer.parseInt(request.getParameter("auction_up"));
//		System.out.println(str);
//		System.out.println(str2);
//		System.out.println(str3);
//		System.out.println(price);
		String uploadpath = request.getRealPath("/");
		int size = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadpath, size, "utf-8", 
				new DefaultFileRenamePolicy());
		
		System.out.println(multi.getParameter("start_date"));
		System.out.println(multi.getParameter("end_date"));
		regDto.setAuction_name(multi.getParameter("auction_name"));
		regDto.setSeller_no(null);
		regDto.setStart_date(multi.getParameter("start_date"));
		regDto.setEnd_date(multi.getParameter("end_date"));
		regDto.setAuction_up(Integer.parseInt(multi.getParameter("auction_up")));
		regDto.setAuction_down(Integer.parseInt(multi.getParameter("auction_down")));
		regDto.setAuction_content(multi.getParameter("auction_content"));
		regDto.setAuction_file(multi.getParameter("auction_file"));
		regDto.setAuction_detailImg(multi.getParameter("auction_detailImg"));
		regDto.setAuction_detailImg2(multi.getParameter("auction_detailImg2"));
		
		if(multi.getFilesystemName("auction_file")!=null && multi.getFilesystemName("auction_detailImg")!=null && multi.getFilesystemName("auction_detailImg2")!=null){ //�뙆�씪�쓽 �씠由꾩쓣 留먰빐以�.
			String auction_file = multi.getFilesystemName("auction_file");
			String auction_detailImg = multi.getFilesystemName("auction_detailImg");
			String auction_detailImg2 = multi.getFilesystemName("auction_detailImg2");
			
			regDto.setAuction_file(auction_file);
			regDto.setAuction_detailImg(auction_detailImg);
			regDto.setAuction_detailImg2(auction_detailImg2);
			
			String pattern = auction_file.substring(auction_file.lastIndexOf(".")+1);
			String headName = auction_file.substring(0, auction_file.lastIndexOf(".")); 
			
			String pattern2 = auction_detailImg.substring(auction_detailImg.lastIndexOf(".")+1);
			String headName2 = auction_detailImg.substring(0, auction_detailImg.lastIndexOf(".")); 
			
			String pattern3 = auction_detailImg2.substring(auction_detailImg2.lastIndexOf(".")+1);
			String headName3 = auction_detailImg2.substring(0, auction_detailImg2.lastIndexOf(".")); 
			
			String imagePath = uploadpath + "\\" + auction_file;
			File src = new File(imagePath);
			
			String imagePath2 = uploadpath + "\\" + auction_detailImg;
			File src2 = new File(imagePath);
			
			String imagePath3 = uploadpath + "\\" + auction_detailImg2;
			File src3 = new File(imagePath);
			
			//�뜽�꽕�씪�씠誘몄�媛앹껜 -> �뙆�씪媛앹껜
			String thumImagePath = uploadpath + "\\" + headName + "_small." + pattern;
			File dest = new File(thumImagePath);
			
			if(pattern.equals("jpg")||pattern.equals("gif")||pattern.equals("png")){
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}else{
			regDto.setAuction_file("");
		}
			
		dao.insert(regDto);
		request.setAttribute("regDto", regDto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("reg_list.reg");
		
		return forward;
		
	}

}
