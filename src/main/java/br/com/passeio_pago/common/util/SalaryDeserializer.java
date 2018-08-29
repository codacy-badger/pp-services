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

    private static final long serialVersionUID = -5773392806959986581L;

    public SalaryDeserializer() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
                try{
                    return new BigDecimal(NumberFormat.getCurrencyInstance().parse(p.readValueAs(String.class)).toString());
                }catch(ParseException e){
                    return null;
                }
    }

}