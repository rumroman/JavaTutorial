package general.tutorial.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Рефлексия -  это способность программного обеспечения к самоанализу(java.lang.reflect и элементами класса Class.).
   С ее помощью можно динамически анализироват компоненты прораммного обечпечения и описывать их свойства во время
   компиляцияя . Наример, с помощью рефлексии можно определить , какие методы , конструкторы и поля поддерживаются
   в конкретном классе. В состав пакета входит несколько интерфейсов. Основной Member, в котором определяются мето-
   ды , позводяющие получать сведения о поле, конструкторе или метода отдельного класса. В этом пакете имеются так
   же восемь классов. AccessibleObject - позволяет обходитьстандартные проверки управления доступом.
 *
 * В классах Constructor, Field, Method определяется ряд методов , которые можно использовать для получения сведений
 * об объекте.
 *
 */

class MyClass{

    private String name;

    private String age;

    public MyClass(String name,String age){

        this.name = name;
        this.age = age;
    }

    public MyClass(){

    }

    private void a(){};

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class ReflectionApp {

    public static void main(String args[]){

        try{
            Class<?> c = Class.forName("general.tutorial.java8.reflection.MyClass");
            // Либо с ссылки на объект
            MyClass myClass = new MyClass();
            c = myClass.getClass();
            System.out.println("Конструкторы :");
            Constructor contructors[] = c.getConstructors();
            Arrays.stream(contructors).forEach(System.out::println);

            System.out.println("Поля: ");
            Field fields[] = c.getFields();
            Arrays.stream(fields).forEach(System.out::println);

            System.out.println("Методы: ");
            Method methods[] = c.getDeclaredMethods();
            Arrays.stream(methods).forEach(System.out::println);
            System.out.println("Приватные методы: ");
            Arrays.stream(methods)
                    .filter(num -> Modifier.isPrivate(num.getModifiers()))
                    .forEach(n -> System.out.println("" + n.getName()));
            System.out.println("Приватные методы: ");
            for(int i = 0; i < methods.length; i++){
                int modifiers = methods[i].getModifiers();
                if(Modifier.isPrivate(modifiers)){
                    System.out.println("" + methods[i].getName());
                }
            }

        } catch (Exception e ) {
            System.out.println("Исключение : " + e);
        }
    }
}
