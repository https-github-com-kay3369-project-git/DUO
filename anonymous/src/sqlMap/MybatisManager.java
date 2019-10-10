package sqlMap;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	private MybatisManager() {};	// 생성자
	
	private static SqlSessionFactory instance;	// SqlSession 객체를 만들어내는 SqlSessioFactory 참조변수.mybatis query를 수행하는 객체
	public static SqlSessionFactory getInstance() {
		Reader reader = null;
		if(reader == null) {
			try {
				// SqlMapConfig.xml(mybatis환경설정) 파일의 정보를 읽어들이는 코드
				String resource = "sqlMap/SqlMapConfig.xml";
				reader = Resources.getResourceAsReader(resource);
				
				// SqlSessionFactory객체 생성
				instance = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(reader != null) reader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return instance;
	}
}