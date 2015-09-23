package com.pika.rest.resources.asm;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.pika.core.services.util.AccountList;
import com.pika.rest.mvc.AccountController;
import com.pika.rest.resources.AccountListResource;
import com.pika.rest.resources.AccountResource;

public class AccountListResourceAsm extends
		ResourceAssemblerSupport<AccountList, AccountListResource> {

	public AccountListResourceAsm() {
		super(AccountController.class, AccountListResource.class);
	}

	@Override
	public AccountListResource toResource(AccountList accountList) {
		List<AccountResource> resList = new AccountResourceAsm()
				.toResources(accountList.getAccounts());
		AccountListResource finalRes = new AccountListResource();
		finalRes.setAccounts(resList);
		return finalRes;
	}
}
