package model;

import dao.AccountDAO;

public class SignUpLogic {
	public boolean execute(Account account) {
		AccountDAO accountDao = new AccountDAO();
		boolean result = accountDao.insert(account);
		return result;
	}
}