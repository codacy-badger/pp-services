package br.com.passeio_pago.module.user.domain.entity;

public enum UserEntityDefinition {
	USERID("USER_ID"),
	FULLNAME("FULL_NAME"),
	LOGIN("LOGIN"),
	PASSWORD("PASSWORD"),
	EMAILS("EMAILS"),
	PHONES("PHONES"),
	CREATEDON("CREATED_ON"),
	ACCOUNTROLEID("ACCOUNT_ROLE_ID"),
	LASTLOGIN("LAST_LOGIN");

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
