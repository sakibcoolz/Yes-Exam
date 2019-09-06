	package in.yis.mains.config;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import in.yis.mains.model.OpsUsersLogin;
import in.yis.mains.model.Privilege;
import in.yis.mains.model.Role;
import in.yis.mains.repo.OpsUsersLoginRepo;
import in.yis.mains.repo.PrivilegeRepository;
import in.yis.mains.repo.RoleRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private OpsUsersLoginRepo opsUsersLoginRepo;
//
	@Autowired
	private RoleRepository roleRepository;
//
	@Autowired
	private PrivilegeRepository privilegeRepository;
//
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
		return;
//########################################################################################
//		List<Long> lg = new ArrayList<Long>();
//		lg.add((long) 1);
//		lg.add((long) 2);
//		lg.add((long) 6);
//		lg.add((long) 7);
//		List<Privilege> pri = new ArrayList<Privilege>();
//		pri = privilegeRepository.findByIdIn(lg);
//		System.out.println(pri.toString());
//		Role adminRole = new Role();
//		adminRole.setName("SK_ROLE");
//		adminRole.setPrivileges(pri);
//		roleRepository.save(adminRole);	
//		Role adminRole = roleRepository.findByName("SK_ROLE");
//		OpsUsersLogin user = new OpsUsersLogin();
//		user.setName("sakib");
//		user.setPassword(passwordEncoder.encode("sakib"));
//		user.setUsername("sakib");
//		user.setOldPassword("sakib");
//		user.setStatus_flag("A");
//		user.setWrong_attampts(0);
//	    Date dateobj = new Date();
//		user.setCreated_date(dateobj);
//		user.setExpiry_date(dateobj);
//		user.setRights(1);
//		user.setAddress("panvel");
//		user.setDesignation("Admin");
//		user.setEmpId(12);
//		user.setCreated_by(dateobj);
//		user.setUpdated_by(dateobj);
//		user.setRoles(Arrays.asList(adminRole));
//		opsUsersLoginRepo.save(user);
//########################################################################################
		
//		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
//		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
//		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
//		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
//		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		
		
//		OpsUsersLogin user = new OpsUsersLogin();
//		user.setName("sakib");
//		user.setPassword(passwordEncoder.encode("sakib"));
//		user.setUsername("sakib");
//		user.setOldPassword("sakib");
//		user.setStatus_flag("A");
//		user.setWrong_attampts(0);
//	    Date dateobj = new Date();
//		user.setCreated_date(dateobj);
//		user.setExpiry_date(dateobj);
//		user.setRights(1);
//		user.setAddress("panvel");
//		user.setDesignation("Admin");
//		user.setEmpId(12);
//		user.setCreated_by(dateobj);
//		user.setUpdated_by(dateobj);
//		user.setRoles(Arrays.asList(adminRole));
//		opsUsersLoginRepo.save(user);
//		alreadySetup = true;
		}

//	@Transactional
//	Privilege createPrivilegeIfNotFound(String name) {
//		Privilege privilege = privilegeRepository.findByName(name);
//		if (privilege == null) {
//			privilege = new Privilege(name);
//			privilegeRepository.save(privilege);
//		}
//		return privilege;
//	}
//
//	@Transactional
//	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
//		Role role = roleRepository.findByName(name);
//		if (role == null) {
//			role = new Role(name);
//			role.setPrivileges();
//			roleRepository.save(role);
//		}
//		return role;
//	}
}
