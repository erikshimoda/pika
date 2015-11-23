package com.cartrader.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cartrader.core.models.entities.Account;
import com.cartrader.core.models.entities.Blog;
import com.cartrader.core.repositories.AccountRepo;
import com.cartrader.core.repositories.BlogRepo;
import com.cartrader.core.services.AccountService;
import com.cartrader.core.services.exceptions.AccountDoesNotExistException;
import com.cartrader.core.services.exceptions.AccountExistsException;
import com.cartrader.core.services.exceptions.BlogExistsException;
import com.cartrader.core.services.util.AccountList;
import com.cartrader.core.services.util.BlogList;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private BlogRepo blogRepo;

	@Override
	public Account findAccount(Long id) {
		return accountRepo.findAccount(id);
	}

	@Override
	public Account createAccount(Account data) {
		Account account = accountRepo.findAccountByName(data.getName());
		if (account != null) {
			throw new AccountExistsException();
		}
		return accountRepo.createAccount(data);
	}

	@Override
	public Blog createBlog(Long accountId, Blog data) {
		Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

		if (blogSameTitle != null) {
			throw new BlogExistsException();
		}

		Account account = accountRepo.findAccount(accountId);
		if (account == null) {
			throw new AccountDoesNotExistException();
		}

		Blog createdBlog = blogRepo.createBlog(data);

		createdBlog.setOwner(account);

		return createdBlog;
	}

	@Override
	public BlogList findBlogsByAccount(Long accountId) {
		Account account = accountRepo.findAccount(accountId);
		if (account == null) {
			throw new AccountDoesNotExistException();
		}
		return new BlogList(blogRepo.findBlogsByAccount(accountId));
	}

	@Override
	public AccountList findAllAccounts() {
		return new AccountList(accountRepo.findAllAccounts());
	}

	@Override
	public Account findByAccountName(String name) {
		return accountRepo.findAccountByName(name);
	}
}
