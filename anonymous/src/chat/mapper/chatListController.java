package chat.mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chat.dao.ChatDAO;
import chat.dto.ChatDTO;


@WebServlet("/chatList_Servlet/*")
public class chatListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ListController");
		
		String listType = request.getParameter("listType");
		if(listType == null || listType.equals("")) response.getWriter().write("");
		else if(listType.equals("today")) response.getWriter().write(getToday());
	}

	public String getToday() {
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		ChatDAO chatDAO = new ChatDAO();
		List<ChatDTO> chatList = chatDAO.list(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		for(int i=0;i<chatList.size();i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getChatName() + "\"},");
			result.append("[{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
			result.append("[{\"value\": \"" + chatList.get(i).getChatTime() + "\"},");
			if(i != chatList.size() - 1) result.append(",");
		}	
		result.append("]}");
		return result.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
