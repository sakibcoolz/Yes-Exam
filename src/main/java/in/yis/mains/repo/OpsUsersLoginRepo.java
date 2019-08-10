package in.yis.mains.repo;

import org.springframework.data.repository.CrudRepository;

import in.yis.mains.model.OpsUsersLogin;

public interface OpsUsersLoginRepo extends CrudRepository<OpsUsersLogin, Long> {
	
}
