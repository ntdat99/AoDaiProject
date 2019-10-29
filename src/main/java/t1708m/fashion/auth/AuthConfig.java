package t1708m.fashion.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return true;
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,status from account where username =?")
                .authoritiesByUsernameQuery("select username,role from user_role where username= ?")
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/en/login", "/vi/login").permitAll()
                .antMatchers("/create", "/edit/**", "/delete/**", "/").hasRole("ADMIN").anyRequest().authenticated()
                .and().formLogin().loginPage("/login").loginProcessingUrl("/login").successHandler((req, res, auth) -> {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                System.out.print(authority.getAuthority());
            }
            req.getSession().setAttribute("msg", auth.getName());
            System.out.print("\nLogged: " + auth.getName() + "\n");
            res.sendRedirect("/");
        }).failureHandler((res, req, exp) -> {
            String errorMsg = "";
            if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
                errorMsg = "* Invalid username or password";
            } else {
                errorMsg = "Unknown error - " + exp.getMessage();
            }
            res.getSession().setAttribute("msg", errorMsg);
            req.sendRedirect("/login");
        }).permitAll().and().logout().logoutUrl("/signout").logoutSuccessHandler((res, req, auth) -> {
            req.sendRedirect("/login");
        }).permitAll().and().csrf().disable();
    }

}