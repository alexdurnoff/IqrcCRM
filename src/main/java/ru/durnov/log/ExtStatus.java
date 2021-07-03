package ru.durnov.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtStatus {
    private final static Pattern pattern = Pattern.compile("ES=[0-9A-Z]{6,10}");
    private final StringBuilder stringBuilder;


    public ExtStatus(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            this.stringBuilder = new StringBuilder(matcher.group());
        } else {
            throw new IllegalArgumentException("No ES string matches");
        }
    }

    public double CurrentActualTemp(){
        double value = Double.parseDouble(
                NumberConverter.convertFrom16To10(
                        this.stringBuilder.substring(5,7)
                )
        );
        return value * 0.25 - 20;
    }

    public double CurrentSetTemp(){
        int value = Integer.parseInt(
                NumberConverter.convert2To10(
                        NumberConverter.convertFrom16To2(
                                this.stringBuilder.substring(7,9)
                        )
                )
        );
        return (value * 0.5) + 5;
    }

    public int extendedOpenStatus(){
        return Integer.parseInt(
                NumberConverter.convert2To10(
                        NumberConverter.convertFrom16To2(
                                this.stringBuilder.substring(7)
                        ).substring(0,2)
                )
        ) * 5;
    }
}
