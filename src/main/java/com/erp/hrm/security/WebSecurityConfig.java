package com.erp.hrm.security;


import com.erp.hrm.repository.UserRepository;
import com.erp.hrm.service.impl.UserServiceImpl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.erp.hrm.util.ErpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;


/**
 * Created by Williyam on 13/04/2018.
 */

@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
    private UserServiceImpl userDetailsService;

//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//		http
//        .antMatcher("/")
//        .authorizeRequests()
//        .antMatchers("/auth/**","/user/login**","/auth/login**").permitAll()
////        .antMatchers("/hr**").authenticated()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/auth/login")
//        .failureUrl("/auth/login")
//        .and()
//        .csrf().csrfTokenRepository(csrfTokenRepository())
//        .and()
//        .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
//        ;
//    }
	
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(getPasswordEncoder())
        		.passwordEncoder(passwordEncoder())
                .and().authenticationProvider(authProvider());
    }


//    private PasswordEncoder getPasswordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return ErpUtils.encoded(charSequence.toString());
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                if( ErpUtils.encoded(charSequence.toString()).equals(s))
//                    return true;
//                return false;
//            }
//        };
//    }
    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    	System.out.println("###BCryptPasswordEncoder HRM ###");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(getPasswordEncoder());
        authProvider.setPasswordEncoder(passwordEncoder());
        System.out.println("###DaoAuthenticationProvider###");
        return authProvider;
    }
    
    
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

// After this is redundant to test for login  ////
    
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
    
    
    class AjaxAwareEntryPoint extends LoginUrlAuthenticationEntryPoint {

        private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
        private static final String X_REQUESTED_WITH = "X-Requested-With";

        public AjaxAwareEntryPoint(String loginFormUrl) {
            super(loginFormUrl);
        }

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            if (XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH))) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                super.commence(request, response, exception);
            }
        }
    }

    class CsrfHeaderFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
            CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
            if (csrf != null) {
                Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                String token = csrf.getToken();
                if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
                    cookie = new Cookie("XSRF-TOKEN", token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
            filterChain.doFilter(request, response);
        }
    }
    
    

}

