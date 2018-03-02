package other.lib.junit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JUnitApp {

    public static void main(String args[]){


    }
}


class ArrayHolder{

    private int [] integers;


    public ArrayHolder(){
        this.integers = new int[]{1,2,3,4,5};
    }

    public int[] getIntegers() {
        return integers;
    }

    public void setIntegers(int[] integers) {
        this.integers = integers;
    }


    @Override

    public String toString(){

        return Arrays.toString(integers);
    }

}

class ArrayHolderTests{

    ArrayHolder arrayHolder = new ArrayHolder();

    @Test

    public void shouldCreateDefaultArrayTest(){

        Assert.assertEquals(arrayHolder.toString(), "[1,2,3,4,5]");

    }
}
