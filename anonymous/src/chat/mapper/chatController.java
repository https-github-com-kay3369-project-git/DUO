package chat.mapper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chat.dao.ChatDAO;


@WebServlet("/chat_Servlet/*")
public class chatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller");
		
		String url = request.getRequestURL().toString();
		// ChatDAO dao = new ChatDAO();
		
		if(url.contains("chat.do")) {
			System.out.println("chat.do OK...");
		}

		String chatName = request.getParameter("chatName");
		String chatContent = request.getParameter("chatContent");
		
		if(chatName == null || chatName.equals("") || chatContent == null || chatContent.equals("")){
			response.getWriter().write("0");
		}
		else {
			response.getWriter().write(new ChatDAO().insert(chatName, chatContent) + "");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
