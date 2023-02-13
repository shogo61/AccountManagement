package model;

import dao.AccountDAO;

public class InfoChangeLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean bool = dao.update(account);
		return bool;
	}
}
