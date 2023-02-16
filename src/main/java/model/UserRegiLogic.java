package model;

import dao.AccountDAO;

public class UserRegiLogic {
	public boolean execute(Account account) {
		AccountDAO adao = new AccountDAO();
		boolean result = adao.insert(account);
		return result;
	}
}
