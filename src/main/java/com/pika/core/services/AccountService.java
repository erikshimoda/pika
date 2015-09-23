package com.pika.core.services;

import com.pika.core.models.entities.Account;
import com.pika.core.models.entities.Blog;
import com.pika.core.services.util.AccountList;
import com.pika.core.services.util.BlogList;

public interface AccountService {
	public Account findAccount(Long id);

	public Account createAccount(Account data);

	public Blog createBlog(Long accountId, Blog data);

	public BlogList findBlogsByAccount(Long accountId);

	public AccountList findAllAccounts();

	public Account findByAccountName(String name);
}
