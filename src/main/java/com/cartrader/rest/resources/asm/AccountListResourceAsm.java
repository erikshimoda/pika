package com.cartrader.rest.resources.asm;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.cartrader.core.services.util.AccountList;
import com.cartrader.rest.mvc.AccountController;
import com.cartrader.rest.resources.AccountListResource;
import com.cartrader.rest.resources.AccountResource;

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
