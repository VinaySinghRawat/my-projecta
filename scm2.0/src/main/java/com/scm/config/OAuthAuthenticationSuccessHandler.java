package com.scm.config;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.entity.Providers;
import com.scm.entity.User;
import com.scm.helper.AppConstants;
import com.scm.repositories.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserRepository userRepo;
	
	Logger logger =LoggerFactory.getLogger(OAuthAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("OAuthAuthenticationSuccessHandler");
	
		// data ko database m bhi toh dalna h 
	DefaultOAuth2User user =(DefaultOAuth2User)authentication.getPrincipal();	
//	
//	logger.info(user.getName());
//	user.getAttributes().forEach((key,value)->{
//		logger.info("{}=>{}",key,value);
//	});
//	logger.info(user.getAuthorities().toString());
		String email=user.getAttribute("email").toString();
		String name=user.getAttribute("name").toString();
		String pucture=user.getAttribute("picture").toString();
		
	//create user and save to database
		User user1 =new User();
		user1.setEmail(email);
		user1.setName(name);
		user1.setProfilePic(pucture);
		user1.setPassword("password");
		user1.setUserId(UUID.randomUUID().toString());
		user1.setProviders(Providers.GOOGLE);
		user1.setEnabled(true);
		user1.setEmailVerified(true);
		user1.setProviderUserId(user.getName());
		user1.setRoleList(List.of(AppConstants.ROLE_USER));
		user1.setAbout("This account is created using google...");

		User user2=userRepo.findByEmail(email).orElse(null);
		if(user2==null) {
			userRepo.save(user1);
			logger.info("User saved"+email);
		}
		//	  response.sendRedirect("/home");
		new DefaultRedirectStrategy().sendRedirect(request,response,"/user/profile");
	}


}
