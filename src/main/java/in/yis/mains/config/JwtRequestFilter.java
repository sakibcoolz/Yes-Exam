package in.yis.mains.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import in.yis.mains.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtRequestFilter implements Filter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//		System.out.println("Req Filter 1");
//		final String requestTokenHeader = request.getHeader("Authorization");
//		System.out.println("Req Filter 2 => "+requestTokenHeader);
//		String username = null;
//		String jwtToken = null;
//		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			System.out.println("Req Filter 2.1 token not null => "+requestTokenHeader);
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			logger.warn("JWT Token does not begin with Bearer String");
//		}
//
//		//Once we get the token validate it.
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			System.out.println("Req Filter 2.2  => "+username);
//			System.out.println("Req Filter 2.3  => "+SecurityContextHolder.getContext().getAuthentication());
//			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//			System.out.println("Req Filter 2.4  =>");
//			// if token is valid configure Spring Security to manually set authentication
//			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//				System.out.println("Req Filter 2.5 ==>");
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				System.out.println("Req Filter 2.6 ==>");
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				System.out.println("Req Filter 2.7 ==>");
//				// After setting the Authentication in the context, we specify
//				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//				System.out.println("Req Filter 2.8 ==>");
//			}
//		}
//		chain.doFilter(request, response);
//	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		System.out.println("Req Filter 1");
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println("Req Filter 2 => "+requestTokenHeader);
		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			System.out.println("Req Filter 2.1 token not null => "+requestTokenHeader);
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			//logger.warn("JWT Token does not begin with Bearer String");
		}

		//Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			System.out.println("Req Filter 2.2  => "+username);
			System.out.println("Req Filter 2.3  => "+SecurityContextHolder.getContext().getAuthentication());
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
			System.out.println("Req Filter 2.4  =>");
			// if token is valid configure Spring Security to manually set authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				System.out.println("Req Filter 2.5 ==>");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				System.out.println("Req Filter 2.6 ==>");
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				System.out.println("Req Filter 2.7 ==>");
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				System.out.println("Req Filter 2.8 ==>");
			}
		}
		

		if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
			try {
				System.out.println("OPTIONS");
				chain.doFilter(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Pre-fight");
			response.setHeader("Access-Control-Allowed-Methods", "POST, GET, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, x-auth-token, "
					+ "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
			response.setStatus(HttpServletResponse.SC_OK);
		}
		
	}
}
