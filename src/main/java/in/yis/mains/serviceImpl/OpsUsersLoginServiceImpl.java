package in.yis.mains.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.yis.mains.dao.OpsUsersLoginDao;
import in.yis.mains.model.OpsUsersLogin;
import in.yis.mains.service.OpsUsersLoginService;

@Repository
public class OpsUsersLoginServiceImpl implements OpsUsersLoginService {

	@Autowired
	OpsUsersLoginDao opsUsersLoginDao;
	
	@Override
	public OpsUsersLogin register(OpsUsersLogin opsUsersLogin) {
		// TODO Auto-generated method stub
		System.out.println("serimpl "+opsUsersLogin.toString());
		return opsUsersLoginDao.register( opsUsersLogin);
	}

	@Override
	public OpsUsersLogin getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return opsUsersLoginDao.getUserByUsername( username);
	}

	
}
