package in.yis.mains.service;

import java.util.List;

import in.yis.mains.model.Privilege;
import in.yis.mains.model.Privileges;

public interface PrivilegesService {

	Privilege CreatePrivileges(Privilege privilege);

	Iterable<Privilege> ListPrivileges();

	List<Privileges> allPrivileges();

}
