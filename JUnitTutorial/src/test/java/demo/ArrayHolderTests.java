package demo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayHolderTests {

    ArrayHolder arrayHolder = new ArrayHolder();

    @Test

    public void shouldCreateDefaultArrayTest(){

        assertEquals(arrayHolder.toString(), "[1, 2, 3, 4, 5]");

    }
}
