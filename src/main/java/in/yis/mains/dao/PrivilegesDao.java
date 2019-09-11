package in.yis.mains.dao;

import java.util.List;

import in.yis.mains.model.Privilege;
import in.yis.mains.model.Privileges;

public interface PrivilegesDao {

	Privilege CreatePrivileges(Privilege privilege);

	Iterable<Privilege> ListPrivileges();

	List<Privileges> allPrivileges();

}
