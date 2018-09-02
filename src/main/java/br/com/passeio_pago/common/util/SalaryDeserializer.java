package br.com.passeio_pago.common.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * BigDecimalDeserializer
 */
public class SalaryDeserializer extends StdDeserializer<BigDecimal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -718925592151208525L;

	public SalaryDeserializer() {
		super(BigDecimal.class);
	}

	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		try {
			String value = p.readValueAs(String.class);
			NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
			Number parse = currencyInstance.parse(value);
			return new BigDecimal(parse.toString());
		} catch (ParseException e) {
			return null;
		}
	}

}