package br.com.passeio_pago.module.user.domain.entity;

public enum UserEntityDefinition {
	USERID			("user_id"),
	FULLNAME		("full_name"),
	LOGIN			("login"),
	PASSWORD		("password"),
	EMAILS			("emails"),
	PHONES			("phones"),
	CREATEDON		("created_on"),
	ACCOUNTROLEID	("account_role_id"),
	LASTLOGIN		("last_login");

	private String meaning;

	private UserEntityDefinition(String meaning) {
		setMeaning(meaning);
	}

	public String getMeaning() {
		return meaning;
	}

	private void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
