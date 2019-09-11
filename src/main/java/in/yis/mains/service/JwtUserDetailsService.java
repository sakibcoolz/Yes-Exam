package in.yis.mains.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.yis.mains.model.OpsUsersLogin;
import in.yis.mains.model.Privilege;
import in.yis.mains.model.Role;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	OpsUsersLoginService opsUsersLoginService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("step 6  "+username);
		OpsUsersLogin opslogin = opsUsersLoginService.getUserByUsername(username);
		System.out.println(" step 6.1 "+opslogin.toString());
//		Gson gson = new Gson();
//		String json = gson.toJson(opslogin);
//		System.out.println("JSON = " + json);
		if (opslogin.getUsername().equals(username)) {
			System.out.println("step 7");
//		if ("javainuse".equals(username)) {
//			System.out.println("step 7");
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>()); 
			
//			return new User(opslogin.getUsername(), opslogin.getPassword(),
//					new ArrayList<>());
			
			return new org.springframework.security.core.userdetails.User(
					opslogin.getUsername(), opslogin.getPassword(), true, true, true, 
			          true, getAuthorities(opslogin.getRoles()));
			
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	
	private Collection<? extends GrantedAuthority> getAuthorities(
		      Collection<Role> roles) {
		  
		        return getGrantedAuthorities(getPrivileges(roles));
		    }
		 
	private List<String> getPrivileges(Collection<Role> roles) {
		  
		        List<String> privileges = new ArrayList<>();
		        List<Privilege> collection = new ArrayList<>();
		        for (Role role : roles) {
		            collection.addAll(role.getPrivileges());
		        }
		        for (Privilege item : collection) {
		            privileges.add(item.getName());
		        }
		        return privileges;
		    }
		 
		    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		        List<GrantedAuthority> authorities = new ArrayList<>();
		        for (String privilege : privileges) {
		            authorities.add(new SimpleGrantedAuthority(privilege));
		        }
		        return authorities;
		    }

}