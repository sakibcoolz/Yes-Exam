package in.yis.mains.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.yis.mains.dao.PrivilegesDao;
import in.yis.mains.model.Privilege;
import in.yis.mains.model.Privileges;
import in.yis.mains.repo.PrivilegeRepository;

@Repository
public class PrivilegesDaoImpl implements PrivilegesDao {

	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Privilege CreatePrivileges(Privilege privilege) {
		// TODO Auto-generated method stub
		return privilegeRepository.save(privilege);
	}

	@Override
	public Iterable<Privilege> ListPrivileges() {
		// TODO Auto-generated method stub
		return privilegeRepository.findAll();
	}
	
	public List<Privileges> allPrivileges() {
		System.out.println("comes here");
		return jdbcTemplate.query("SELECT ID, NAME FROM privilege", (rs, rowNum) -> new Privileges(rs.getLong("ID"), rs.getString("NAME").toString()) );
	}

}
