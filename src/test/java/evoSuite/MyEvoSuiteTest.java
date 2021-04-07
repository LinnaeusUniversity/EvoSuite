package evoSuite;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyEvoSuiteTest {

    @Test
    public void add() {


            MyEvoSuite myEvoSuite=new MyEvoSuite();
            int a=5;
            int b=3;
            int expected=myEvoSuite.add(a,b);
            int actual=a + b;
            assertEquals(expected,actual);
        }

    }