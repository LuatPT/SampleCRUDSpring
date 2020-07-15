package security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter{
	@Override
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
			User.withDefaultPasswordEncoder().username("admin").password("123").roles("ADMIN").build()
		);
		return manager;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http                              
        .authorizeRequests()  
            .anyRequest().hasRole("ADMIN")  
            .and().formLogin().and()  
        .httpBasic()  
        .and()  
        .logout()  
        .logoutSuccessUrl("/");  
    }  
		
}
