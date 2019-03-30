package general.tutorial.java8.lambda;


import com.fasterxml.jackson.core.type.TypeReference;

import javax.swing.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.lang.reflect.Type;

interface StringFunc {

    String func(String n);


}

@FunctionalInterface
interface MyTest<T>{

    Type getType();
}



@FunctionalInterface
interface MyFunc2{
    int func(int i);
}

public class LambdaDemo {

    //private int num ;

    public static int getNum() {
        return 1 + 1;
    }

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {

        int num = 5;

        //MyFunc2 a = n -> (n % 2) == 0;
        MyFunc2 b = n -> {
            return n + num;     // Захват переменнной num - локальная, завершенная(не изменяемая, иницаилизируется один раз) переменная
        };
        //System.out.println("" + a.test(9));

        String inStr = "Лямбда выражения повышают эффективность Java";
        String outStr;

        StringFunc stringf = new StringFunc() {
            @Override
            public String func(String n) {
                return null;
            }
        };

        TypeReference<String> typeReference = new TypeReference<String>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };


        Timer t = new Timer(1000,System.out::println);
        t.start();






        StringFunc stringFunc = (str) -> {

            String result = "";
            int i;

            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            }
            return result;
        };

        /**
         * Передача лямбда выражений в качестве аргументов методов.
         * Для передачи лямбда , нужно , чтобы параметр метода имел тип
         * фунуционального интерфейса  совместимого с этим лямбдой выражением.
         */

        outStr = stringOp(stringFunc, inStr);

        MyStringOps myStringOps = new MyStringOps();

        /**
         * Здесь ссылка на метод strReverse() передается методу stringOp()         *
         */
        outStr = stringOp(myStringOps::strReverse,inStr);


        /**
         * Лямбда выражения и захват переменных.
         * Переменные , определяемые в объемлющей обласи действия лямбда-
         * выражения, доступныв этом выражении.
         * Если в лямбда-выражении используется локальная переменная из объемлю-
         * щей его области действия, то возникает особый случай , называемый
         * захватом переменной .В этом случае в лямбда-выражении можно использовать
         * только те локальные переменные, которые действительно являются завершенными.
         * Действительно завершенной считается такая переменная , значение которой не
         * не изменяется после ее первого присваивания.
         *    Локальная переменная из объемлющей области действия не может быть видо-
         * изменена в лямбда выражении.
         */

        // Локальная переменная , которая может быть захвачена
        //int num = 10;

        MyFunc2 myLambda = (n) -> {
            int v = num + n;   // Такое применение переменной num допустимо

//          num++ ;            // Такая строка кода не допустима, поскольку num нельзя изменять
            return v;
        };

    }
}

/**
     * Ссылки на методы
     * Статические методы
     */
    class MyStringOps{

         String strReverse(String str){
            String res = "";
            int i ;

            for(i = str.length()-1; i >= 0; i--){
                res += str.charAt(i);
            }
            return res;
        }


}


interface A {

        int sum();
}

class B implements  A{


    @Override
    public int sum() {
        return 0;
    }
}


class C extends B {


}

class D {

        public void s(){

            A ac = new C();
        }
}

