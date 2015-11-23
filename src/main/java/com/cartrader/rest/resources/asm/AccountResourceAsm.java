package com.cartrader.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.cartrader.core.models.entities.Account;
import com.cartrader.rest.mvc.AccountController;
import com.cartrader.rest.resources.AccountResource;

public class AccountResourceAsm extends
		ResourceAssemblerSupport<Account, AccountResource> {
	public AccountResourceAsm() {
		super(AccountController.class, AccountResource.class);
	}

	@Override
	public AccountResource toResource(Account account) {
		AccountResource res = new AccountResource();
		res.setName(account.getName());
		res.setPassword(account.getPassword());
		res.setRid(account.getId());
		res.add(linkTo(
				methodOn(AccountController.class).getAccount(account.getId()))
				.withSelfRel());
		res.add(linkTo(
				methodOn(AccountController.class).findAllBlogs(account.getId()))
				.withRel("blogs"));
		return res;
	}
}
