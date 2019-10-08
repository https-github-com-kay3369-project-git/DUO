package member;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Constans;


@WebServlet("/member_servlet/*")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller 이동확인");
		
		String url = request.getRequestURL().toString();
		memberDAO dao = new memberDAO();
// 회원 목록		
		if(url.contains("listMembers.do")) {
				System.out.println("listMembers.do 이동확인");
				
				List<memberDTO> list = dao.list();
				
				request.setAttribute("list", list);
				
				String page = "/member/listMembers.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);

// 회원가입 요청
		} else if (url.contains("joinMember.do")) {
			System.out.println("joinMember.do 이동확인");
			
			// 회원가입 폼 이동
			String page = "/member/addMember.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);		

// 회원 가입			
		}else if (url.contains("addMember.do")) {
			System.out.println("addMember.do 이동확인");
			
			memberDTO dto = new memberDTO();
		
			// upload할 폴더 설정
			File uploadDri = new File(Constans.UPOAD_PATH);
			//upload 파일 유무 체크
			if(!uploadDri.exists()) {
				// true 일 경우 설정한 경로에 폴더생성
				uploadDri.mkdir();
			}
			// upload 라이브러리 활용 : cos.jar
			MultipartRequest multi = new MultipartRequest(
					request,
					Constans.UPOAD_PATH,
					Constans.MAX_UPLOAD,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			// 기존의 request 객체 역할을 MultipartRequest 객체가 수행
			
			String photo ="";
			int filesize = 0;
			
			// 첨부파일에 대한 처리: 입,출력 객체 사용시 무조건  IO예외 발생
			try {
				// 첨부파일 목록(파일이 하나 이상일 경우 한번에 처리)
				Enumeration files = multi.getFileNames();
				while(files.hasMoreElements()) {
					//요소가 있으면 조회 없으면 다음으로 이동
					String file1 = (String) files.nextElement();
					
					//요소의 파일이름 추출
					photo = multi.getFilesystemName(file1);
					
					File f1 = multi.getFile(file1);
					//파일 용량추출
					if(f1!=null) filesize = (int) f1.length();
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// joinMember.jsp 폼에서 넘어온 인자 처리
			String id = multi.getParameter("id");
			String pwd = multi.getParameter("pwd");
			String nick_name = multi.getParameter("nick_name");
			String email = multi.getParameter("email");
			String address = multi.getParameter("address");
			String gender = multi.getParameter("gender");
			String birth = multi.getParameter("birth");
			String phone = multi.getParameter("phone");
			photo = multi.getParameter("photo"); 
			
			System.out.println("id : "+id);
			
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setNick_name(nick_name);
			dto.setEmail(email);
			dto.setAddress(address);
			dto.setGender(gender);
			dto.setBirth(birth);
			dto.setPhone(phone);
		
			System.out.println("DTO : "+dto);
			
			//첨부파일 없을경우 '-'로 대체
			
			 if(photo == null || photo.trim().equals("")) { 
				 photo ="-";
			  dto.setPhoto(photo); 
			  }else {
				  
				  dto.setPhoto(photo); 
				  }
			 
			
			dao.insertMember(dto);
			
			//페이지 이동: 정상적으로 회원가입완료되면 로그인 화면 이동
			String page = request.getContextPath()+"/member/login.do";
			response.sendRedirect(page);	
			
		}else if (url.contains("login.do")) {// 로그인 요청
			System.out.println("login.do 이동확인");
			
			String page = request.getContextPath()+"/index.jsp";// 로그인 화면폼 이동 
			response.sendRedirect(page);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
