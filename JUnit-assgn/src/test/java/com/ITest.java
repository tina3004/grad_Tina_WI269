package com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ITest {

    @Test
    @DisplayName("Test interface method")
    public void test1(){
        I obj=mock(I.class);
        obj.abc();
    }

    @Test
    @DisplayName("Test a method which returns nothing")
    public void test2(){
        I obj=mock(I.class);
        obj.abc();
        verify(obj).abc();

    }

    @Test
    @DisplayName("Check method call n number of times")
    public void test3(){
        I obj=mock(I.class);
        int n=5;
        for(int i=0;i<n;i++){
            obj.abc();
        }
        verify(obj,times(n)).abc();
    }
}
