//
//package com.example.demo.config;
//
//
//import org.apache.naming.factory.BeanFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.example.demo.Service.UserDetailsServiceImpl;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//    	http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/journal/**").authenticated()
//                .anyRequest().permitAll()
//        )
//        .httpBasic(Customizer.withDefaults())
//        .csrf(AbstractHttpConfigurer::disable);
//return http.build();
//                
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//	
//}
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.Service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    private final UserDetailsServiceImpl userDetailsService;

    public SpringSecurity(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    	return http.authorizeHttpRequests(request -> request
//                .requestMatchers("/public/**").permitAll()
//                .requestMatchers("/journal/**", "/user/**").authenticated()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated())
//        .httpBasic(Customizer.withDefaults())
//        .csrf(AbstractHttpConfigurer::disable)
//        .build();
    	
    	
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/journal/**").authenticated()
//                .requestMatchers("/user/**").permitAll() // Allow access to UserController endpoints
//                .anyRequest().permitAll()
//            )
//            .httpBasic(Customizer.withDefaults())
//            .csrf(AbstractHttpConfigurer::disable)
//            .userDetailsService(userDetailsService)
//            .authenticationProvider(authenticationProvider());
//
//        return http.build();
    	
    	
//    	http.authorizeHttpRequests(authorize -> authorize
//                .anyRequest().permitAll()
//            )
//            .csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
    	
    	http.authorizeHttpRequests(authorize -> authorize
    			 .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/journal/**").authenticated()
                .requestMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults()) // Use basic authentication for simplicity
            .csrf(AbstractHttpConfigurer::disable); // Disable CSRF protection if not needed

        return http.build();
    }

    @Bean
    @Lazy
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}


//.requestMatchers("/public/**").permitAll()
//.requestMatchers("/admin/**").hasRole("ADMIN")
//.anyRequest().authenticated())
//.httpBasic(Customizer.withDefaults())
//.csrf(AbstractHttpConfigurer::disable)
//.build();