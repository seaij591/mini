package com.shop.product;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class ProductInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		String pdId = request.getParameter("pdId");
//		String pdCategory = request.getParameter("pdCategory");
//		String pdName = request.getParameter("pdName");
//		String pdSize = request.getParameter("pdSize");
//		String pdColor = request.getParameter("pdColor");
//		String pdPrice = request.getParameter("pdPrice");
//		String pdImage1 = request.getParameter("pdImage1");
//		String pdImage2 = request.getParameter("pdImage2");
//		String pdImage3 = request.getParameter("pdImage3");
//		String pdContent = request.getParameter("pdContent");

		response.setCharacterEncoding("UTF-8");

		System.out.println("doPost call()");
		String path = "c:/tmp";

		ServletContext sc = request.getServletContext();
		path = sc.getRealPath("upload"); // 서버상경로.

		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, // 요청정보
					path, // 저장위치
					8 * 1024 * 1024, // 용량
					"UTF-8", // 인코딩
					new DefaultFileRenamePolicy());

			Enumeration en = multi.getFileNames();
			String pdId = multi.getParameter("pdId");
			String pdCategory = multi.getParameter("pdCategory");
			String pdName = multi.getParameter("pdName");
			String pdPrice = multi.getParameter("pdPrice");
			String pdContent1 = multi.getParameter("pdContent1");
			String pdContent2 = multi.getParameter("pdContent2");

			String fileN = null;
			ProductVO vo = new ProductVO();
			Map<String, String> map = new HashMap<>();
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
				String fileName = multi.getFilesystemName(name);
				fileN = fileName;
				System.out.println("name: " + name + ", fileName: " + fileName);

				if (name.equals("pdImage3")) {
					vo.setPdImage3(fileName);
				} else if (name.equals("pdImage2")) {
					vo.setPdImage2(fileName);
				} else if (name.equals("pdImage1")) {
					vo.setPdImage1(fileName);
				}
				//map.put(name, fileName);
			}
			vo.setPdName(pdName);
			vo.setPdId(pdId);
			vo.setPdCategory(pdCategory);
			vo.setPdPrice(pdPrice);
			vo.setPdContent1(pdContent1);
			vo.setPdContent2(pdContent2);
//		vo.setPdImage1(pdImage1);
//		vo.setPdImage2(pdImage2);
//		vo.setPdImage3(pdImage3);

			System.out.println(vo);
			ProductService service = new ProductServiceImpl();

			service.insertProduct(vo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productForm.do";
	}

}
