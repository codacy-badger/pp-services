package br.com.passeio_pago.module.user.domain.dto;

import br.com.passeio_pago.module.user.domain.UserPublic;
import io.swagger.annotations.ApiModel;

/**
 * Returns user public information from the Rest controller.
 */
@ApiModel
public class UserPublicDto implements UserPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2461730997339498899L;

	private Integer userId;
	private String login;

	public UserPublicDto(UserPublic userPublic) {
		this(userPublic.getUserId(), userPublic.getLogin());
	}

	public UserPublicDto() {
		super();
	}

	public UserPublicDto(Integer userId, String login) {
		super();
		this.userId = userId;
		this.login = login;
	}

	@Override
	public Integer getUserId() {
		return userId;
	}

	@Override
	public String getLogin() {
		return login;
	}

}
