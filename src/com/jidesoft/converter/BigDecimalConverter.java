package com.jidesoft.converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Converter for BigDecimal.
 */
public class BigDecimalConverter extends NumberFormatConverter {

    public BigDecimalConverter() {
        super(new DecimalFormat("#,##0.00"));
    }

    public BigDecimalConverter(NumberFormat format) {
        super(format);
    }

    @Override
    public Object fromString(String string, ConverterContext context) {
        Object value = super.fromString(string, context);
        if (value instanceof Double) {
            return new BigDecimal(string);
        }
        else if (value instanceof Long) {
            return new BigDecimal((Long) value);
        }
        else if (value instanceof Integer) {
            return new BigDecimal((Integer) value);
        }
        else if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value);
        }
        return value;
    }

    @Override
    public String toString(Object obj, ConverterContext convertercontext) {
        if (obj instanceof BigDecimal) {
            BigDecimal decimal = (BigDecimal) obj;
            if (decimal.doubleValue() == Double.NaN)
                return "";
            return super.toString(decimal, convertercontext);
        }
        return ""; // null or not an instance of BigDecimal
    }
}
