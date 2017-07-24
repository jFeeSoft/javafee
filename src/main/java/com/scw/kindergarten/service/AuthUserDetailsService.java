package com.scw.kindergarten.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scw.kindergarten.model.Permission;
import com.scw.kindergarten.model.Role;
import com.scw.kindergarten.model.SystemUser;
import com.scw.kindergarten.repository.UzytkownikRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private UzytkownikRepository uzytkownikRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		SystemUser uzytkownik = uzytkownikRepository.findByEmail(userName);

		User userdetails = new User(uzytkownik.getSurname(), uzytkownik.getPassword(), uzytkownik.getIsActive(),
				accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(uzytkownik.getRoles()));

		return userdetails;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> role) {
		return getGrantedAuthorities(getPrivileges(role));
	}

	private List<String> getPrivileges(Collection<Role> roles) {

		List<String> privileges = new ArrayList<>();
		List<Permission> collection = new ArrayList<>();
		roles.forEach(role -> collection.addAll(role.getPermissions()));
		collection.forEach(permission -> privileges.add(permission.getName()));
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
