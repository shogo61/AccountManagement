package model;

import java.util.ArrayList;

import dao.AccountDAO;

public class UserManagmentLogic {
	public ArrayList<Account> execute() {
		AccountDAO account = new AccountDAO();
		ArrayList<Account> result = account.findAll();
		return result;
	}
}
