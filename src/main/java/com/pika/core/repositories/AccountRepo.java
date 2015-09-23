package com.pika.core.repositories;

import java.util.List;

import com.pika.core.models.entities.Account;

public interface AccountRepo {
	public List<Account> findAllAccounts();

	public Account findAccount(Long id);

	public Account findAccountByName(String name);

	public Account createAccount(Account data);
}
