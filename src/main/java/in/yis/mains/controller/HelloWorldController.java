package in.yis.mains.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.yis.mains.model.OpsUsersLogin;
import in.yis.mains.model.Privilege;
import in.yis.mains.model.Privileges;
import in.yis.mains.service.OpsUsersLoginService;
import in.yis.mains.service.PrivilegesService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@Log4j2
public class HelloWorldController {
	
	@Autowired
	OpsUsersLoginService opsUsersLoginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	PrivilegesService privilegesService;
	
	
	Logger logger = LogManager.getLogger(HelloWorldController.class);
	@RequestMapping({ "/hello" })
	public String hello() {
		logger.trace("A TRACE Message");
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
		return "Hello World";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public OpsUsersLogin register(@RequestBody OpsUsersLogin opsUsersLogin ) {
		System.out.println(opsUsersLogin.toString());
		opsUsersLogin.setPassword(passwordEncoder.encode(opsUsersLogin.getPassword()));
		return opsUsersLoginService.register(opsUsersLogin);
	}
	
	@RequestMapping(value="/privileges/add-privileges", method=RequestMethod.POST)
	public Privilege CreatePrivileges(@RequestBody Privilege privilege) {
		System.out.println(privilege.toString());
		logger.info("This is an info message --> Add Privileges is "+privilege.toString());
		return privilegesService.CreatePrivileges(privilege);
	}
	
//	@RequestMapping(value="/privileges", method=RequestMethod.GET)
//	public Iterable<Privilege> ListPrivileges() {
//		return privilegesService.ListPrivileges();
//	}
	
	@RequestMapping(value="/privileges", method=RequestMethod.GET)
	public List<Privileges> allPrivileges() {
		System.out.println("in comming");
		return privilegesService.allPrivileges();
	}

}
