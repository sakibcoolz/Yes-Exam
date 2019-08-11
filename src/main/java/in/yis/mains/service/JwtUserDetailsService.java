package in.yis.mains.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.yis.mains.model.OpsUsersLogin;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	OpsUsersLoginService opsUsersLoginService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("step 6");
		OpsUsersLogin opslogin = opsUsersLoginService.getUserByUsername(username);
		if (opslogin.getUsername().equals(username)) {
			System.out.println("step 7");
			
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
			
			return new User(opslogin.getUsername(), opslogin.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}