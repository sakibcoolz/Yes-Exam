package in.yis.mains.jdbc;


import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import in.yis.mains.model.Privileges;

public class PrivilegesJdbc {

	@Autowired
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Privileges> allPrivileges() {
		String sql = "SELECT ID, NAME FROM privilege";
		
//		Connection conn = null; 
//		
//		try {
//			conn = 
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		return null;
	}
	

}
