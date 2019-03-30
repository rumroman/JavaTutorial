package general.tutorial.java8.lambda;


interface MyFunc<R,T> {
    R func(T n);
}

class MyClass<T> {

    private T val;

    // Конструктор принимающий один параметр
    MyClass(T v) {val = v;}

    MyClass() {val = null;}

    T getVal(){return val;}
}

// Простой необобщенный класс
class MyClass2{

    String str;

    //Конструктор принимающий один аргумент
    MyClass2(String s) {str = s;}

    MyClass2() {str = null;}

    String getVal() {return str;}
}


public class LambdaConstr {

    static <R,T> R myClassFactory(MyFunc<R,T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String  args[]){

        /**
         * Создать ссылку на конструктор класса MyClass
         * В данном случае оператор new обращается к конструктору ,
         * принимающему аргумент
         */
        MyFunc<MyClass<Double>,Double> myClassDoubleMyFunc = MyClass<Double>::new;

        // Создать класс экземпляра  типа класса Mtclass , используя фабричный метод
        MyClass<Double> myClass = myClassDoubleMyFunc.func(100.1);

        System.out.println("Значение val равно " + myClass.getVal());

        /**
         * А теперь создать экземпляяр другого класса
         * используя метод myClassFactory()
         */
        MyFunc<MyClass2,String> myClass2StringMyFunc = MyClass2::new;

        MyClass2 myClass2 = myClass2StringMyFunc.func("Лямбда");

        System.out.println("Значение str в объекте mc2 равно " + myClass2.getVal());


        /** Как видите , метод myClassFactory() используется для создания обектов типа
         * MyClass<Double> и MyClass2. Несмотря на отличия в обоих классах, в частности,
         * класс MyClass является обобщенным , а клсс MyClass2 - необобщенным , объекты
         * обоих классов могут быть созданы с помощью фабричного метода Myclass
         * Factory() , поскольку оба они содержат конструкторы, совместимые с методом
         * func() из функционального интерфейса MyFunc, а методу MyClass Factory() пере-
         * дается контруктор того класа, объект котого требуется создать.
         *
         * Для создания ссылки на конструктор массива служитт следующая форма:
         *    тип[]::new
         * где тип обозначает создаваемый объект.
         */
    }


}


