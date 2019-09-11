package in.yis.mains.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.yis.mains.model.Privilege;
import in.yis.mains.model.Privileges;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Privilege findByName(String name);

	List<Privilege> findByIdIn(List<Long> lg);

//	@Query("select new in.yis.mains.model.Privileges(p.id, p.name) from Privilege p")
//	List<Privileges> findIdsAndNames();
	
//	@Query("select p.id, p.name from Privilege p")
//	List<Privileges> findIdsAndNames();

}
