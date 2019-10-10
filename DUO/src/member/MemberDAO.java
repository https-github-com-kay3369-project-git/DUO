package member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sqlMap.MybatisManager;

public class memberDAO {
	
// 회원 리스트 출력
	public List<memberDTO> list(){
		SqlSession session = MybatisManager.getInstance().openSession();
		List<memberDTO> list  = session.selectList("member.memberList");
		session.commit();
		session.close();
		return list;
	}

// 회원가입
	public void insertMember(memberDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("member.insertMember", dto);
		session.commit();
		session.close();
	}
}
