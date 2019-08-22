package in.yis.mains.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.yis.mains.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Privilege findByName(String name);

	List<Privilege> findByIdIn(List<Long> lg);

}
