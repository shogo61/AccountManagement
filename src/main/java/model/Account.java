package model;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String pass;
	private String name;
	private String birth;
	private String mail;
	private String tel;
	private String active;
	private String role;

	public Account() {}
	public Account(String id, String pass, String name, String birth, String mail, String tel, String role, String active) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.birth = birth;
		this.mail = mail;
		this.tel = tel;
		this.active = active;
		this.role = role;
	}

	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getMail() {
		return mail;
	}
	public String getTel() {
		return tel;
	}
	public String getRole() {
//		if (role.equals("1")) {
//			active = "Users";
//		} else {
//			active = "Admins";
//		}
		return role;
	}
	public String getActive() {
//		if (active.equals("1")) {
//			role = "アクティブ";
//		} else {
//			role = "非アクティブ";
//		}
		return active;
	}
}