package in.yis.mains.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.yis.mains.dao.PrivilegesDao;
import in.yis.mains.model.Privilege;
import in.yis.mains.model.Privileges;
import in.yis.mains.service.PrivilegesService;

@Repository
public class PrivilegesServiceImpl implements PrivilegesService {
	
	@Autowired
	PrivilegesDao privilegesDao;

	@Override
	public Privilege CreatePrivileges(Privilege privilege) {
		return privilegesDao.CreatePrivileges( privilege);
	}

	@Override
	public Iterable<Privilege> ListPrivileges() {
		// TODO Auto-generated method stub
		return privilegesDao.ListPrivileges();
	}

	@Override
	public List<Privileges> allPrivileges() {
		// TODO Auto-generated method stub
		return privilegesDao.allPrivileges();
	}



}
