package br.com.passeio_pago.common.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * BigDecimalSerializer
 */
public class SalarySerializer extends StdSerializer<BigDecimal> {

    private static final long serialVersionUID = -7150348506047605714L;

    public SalarySerializer() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(NumberFormat.getCurrencyInstance().format(value));
    }

}