package in.yis.mains.service;

import in.yis.mains.model.OpsUsersLogin;

public interface OpsUsersLoginService {

	OpsUsersLogin register(OpsUsersLogin opsUsersLogin);

	OpsUsersLogin getUserByUsername(String username);

}
