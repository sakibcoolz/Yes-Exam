package in.yis.mains.controller;

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
import in.yis.mains.service.OpsUsersLoginService;


@RestController
@CrossOrigin()
//@Log4j2
public class HelloWorldController {
	
	@Autowired
	OpsUsersLoginService opsUsersLoginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
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

}
