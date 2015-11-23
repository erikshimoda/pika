package com.cartrader.core.services;

import com.cartrader.core.models.entities.Account;
import com.cartrader.core.models.entities.Blog;
import com.cartrader.core.services.util.AccountList;
import com.cartrader.core.services.util.BlogList;

public interface AccountService {
	public Account findAccount(Long id);

	public Account createAccount(Account data);

	public Blog createBlog(Long accountId, Blog data);

	public BlogList findBlogsByAccount(Long accountId);

	public AccountList findAllAccounts();

	public Account findByAccountName(String name);
}
