package ru.durnov.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicStatus {
    private final Pattern pattern = Pattern.compile("S=[0-9A-Z]{4,7}");
    private final StringBuilder stringBuilder;

    public BasicStatus(StringBuilder stringBuilder) {
        Matcher matcher = pattern.matcher(stringBuilder);
        if (matcher.find()){
            this.stringBuilder = new StringBuilder(matcher.group());
        } else {
            throw new IllegalArgumentException("No Status string match found");
        }
    }

    public BasicStatus(String string) {
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()){
            this.stringBuilder = new StringBuilder(matcher.group());
        } else {
            throw new IllegalArgumentException("No Status string match found");
        }
    }

    public int openStatus(){
        String value2Str = NumberConverter.convertFrom16To2(
                this.stringBuilder.substring(4,6)
        );

        return Integer.parseInt(
                NumberConverter.convert2To10(
                        value2Str.substring(value2Str.length() - 3)
                )
        ) * 20;
    }

    public String lqi(){
        return NumberConverter.convert2To10(
                NumberConverter.convertFrom16To2(
                        this.stringBuilder.substring(4,6)
                ).substring(0,2)
        );
    }

    public int error(){
        return Integer.parseInt(
                String.valueOf(
                        NumberConverter.convertFrom16To2(
                                this.stringBuilder.substring(4,6)
                        ).charAt(3)
                )
        );
    }

    public int battery(){
        return Integer.parseInt(
                String.valueOf(
                        NumberConverter.convertFrom16To2(
                                this.stringBuilder.substring(4,6)
                        ).charAt(2)
                )
        );
    }

    public int fMode(){
        return Integer.parseInt(
                String.valueOf(
                        NumberConverter.convertFrom16To2(
                                this.stringBuilder.substring(4,6)
                        ).charAt(4)
                )
        );
    }
}
