package in.yis.mains.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.yis.mains.dao.OpsUsersLoginDao;
import in.yis.mains.model.OpsUsersLogin;
import in.yis.mains.repo.OpsUsersLoginRepo;

@Repository
public class OpsUsersLoginDaoImpl implements OpsUsersLoginDao {

	@Autowired
	OpsUsersLoginRepo opsUsersLoginRepo;
	
	@Override
	public OpsUsersLogin register(OpsUsersLogin opsUsersLogin) {
		// TODO Auto-generated method stub
		System.out.println("in DaoImpl");
		System.out.println("repo "+opsUsersLogin.toString());
		return opsUsersLoginRepo.save(opsUsersLogin);
	}

}
