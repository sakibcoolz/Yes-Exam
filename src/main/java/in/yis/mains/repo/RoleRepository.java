package in.yis.mains.repo;

import org.springframework.data.repository.CrudRepository;

import in.yis.mains.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String string);

}
