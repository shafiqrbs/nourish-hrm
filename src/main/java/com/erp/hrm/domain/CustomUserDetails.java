package com.erp.hrm.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetails extends User implements UserDetails {
    
	private static final long serialVersionUID = 1L;

	public CustomUserDetails() {
        
    }
	
	public CustomUserDetails(final User user) {
        super(user);
    }

//	@Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<UserRole> roles = getRoleList();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//         
//        for (UserRole role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getUserRoleName().toUpperCase()));
//        }
//        System.out.println("authorities in LoggedinUserDetails---> "+authorities.toString());
//        return authorities;
//    }
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("authorities in HRM---> ");
		List<GrantedAuthority> roleList =  getRoleList()
            .stream()
            .map( role -> new SimpleGrantedAuthority("ROLE_"+role.getUserRoleName()))
            .collect(Collectors.toList());
        System.out.println("authorities in CustomUserDetails of HRM---> ");
        return roleList;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        List<GrantedAuthority> roleList =  getRoles()
////                .stream()
////                .map( role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
////                .collect(Collectors.toList());
//        String role = super.getIsAdmin() == 1 ? "ADMIN":"USER";
//        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
//        list.add(new SimpleGrantedAuthority("ROLE_" + role));
//
//        List<GrantedAuthority> roleList = list.stream().collect(Collectors.toList());
//        return roleList;
//    }

    @Override
    public String getUsername() {
    	System.out.println("Email in CustomUserDetails of HRM---> ");
        return super.getEmail();
//    	return super.getUserName();
    }
    @Override
    public String getPassword() {
    	System.out.println("Password in CustomUserDetails of HRM---> ");
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
