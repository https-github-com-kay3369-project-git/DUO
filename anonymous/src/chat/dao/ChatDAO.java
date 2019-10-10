package chat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import chat.dto.ChatDTO;
import sqlMap.MybatisManager;

public class ChatDAO {
	// 채팅 내용 조회
	public List<ChatDTO> list(String nowTime){
		SqlSession session = MybatisManager.getInstance().openSession();
		List<ChatDTO> list = session.selectList("chat.select", nowTime);
		session.close();
		
		return list;
	}
	// 채팅 내용 입력
	public int insert(String chatName, String chatContent) {
		SqlSession session = MybatisManager.getInstance().openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chatName", chatName);
		map.put("chatContent", chatContent);
		int insert = session.insert("chat.insert", map);
		session.commit();
		session.close();
		
		return insert;
	}
	
}
