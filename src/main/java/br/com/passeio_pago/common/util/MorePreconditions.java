package br.com.passeio_pago.common.util;

import org.apache.commons.lang3.StringUtils;

import br.com.passeio_pago.common.exception.BadRequestException;

public final class MorePreconditions {
	public static void checkNotNullOrEmptyWithBadRequest(String value) {
		if (StringUtils.isBlank(value)) {
			throw new BadRequestException(CommonConstants.ERROR_REQUIRED_VALUE_EMPTY_OR_NULL);
		}
	}

	public static void checkPagination(Integer pageSize, Integer pageNum) throws BadRequestException {
		if (pageSize == null || pageSize <= 0) {
			throw new BadRequestException(CommonConstants.ERROR_INVALID_PAGE_SIZE);
		}
		if (pageNum == null || pageNum < 0) {
			throw new BadRequestException(CommonConstants.ERROR_INVALID_PAGE_NUMBER);
		}
	}
}
