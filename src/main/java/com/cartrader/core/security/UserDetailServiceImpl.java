package com.cartrader.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cartrader.core.models.entities.Account;
import com.cartrader.core.services.AccountService;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService service;

	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		Account account = service.findByAccountName(name);
		if (account == null) {
			throw new UsernameNotFoundException("no user found with " + name);
		}
		return new AccountUserDetails(account);
	}
}
