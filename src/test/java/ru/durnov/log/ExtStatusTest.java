package ru.durnov.log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtStatusTest {
    private final String source = "i=001, MAC=0XA0E25A022000117D, NWK=0X0001, P=000, M=001, S=0XD5, F=0X11, ES=0XA522";
    private final ExtStatus extStatus = new ExtStatus(source);

    @Test
    void test(){
        assertEquals(extStatus.extendedOpenStatus(), 0);
        assertEquals(extStatus.CurrentActualTemp(), 21.25, 0.0001);
        assertEquals(extStatus.CurrentSetTemp(), 22.0, 0.0001);
    }

}