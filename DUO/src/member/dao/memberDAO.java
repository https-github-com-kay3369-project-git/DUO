package member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import member.dto.memberDTO;
import sqlMap.MybatisManager;

public class memberDAO {
	
	// 회원가입
	public void addMember(memberDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("member.addMember",dto);
		session.commit();
		session.close();
	}
	
	// 로그인
		public memberDTO loginCheck(String id, String pwd) {
			SqlSession session = MybatisManager.getInstance().openSession();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("pwd", pwd);
			
			memberDTO result = session.selectOne("member.login_check", map);
			session.close();
			
			return result;
		}
}
