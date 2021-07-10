package ru.durnov.log;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class BasicStatusTest {
    private final String source = "i=001, MAC=0XA0E25A022000117D, NWK=0X0001, P=000, M=001, S=0XD5, F=0X11, ES=0XA522";
    private final BasicStatus basicStatus = new BasicStatus(source);

    @Test
    void testOpenStatus(){
        assertEquals(basicStatus.openStatus(), 100);
    }

    @Test
    void testError(){
        assertEquals(1, basicStatus.error());
    }

    @Test
    void testFMode(){
        assertEquals(basicStatus.fMode(), 0);
    }

    @Test
    void testBattery(){
        assertEquals(basicStatus.battery(), 0);
    }


    @Test
    void testLQI(){
        assertEquals(basicStatus.lqi(), String.valueOf(3));
    }

}