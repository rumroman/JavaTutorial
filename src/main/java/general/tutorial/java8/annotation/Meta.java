package general.tutorial.java8.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

public class Meta {

    @MyAnno(str = "example annotation", val = 100)
    public static void myMeth(){
        Meta ob = new Meta();

        // Получить аннотацию из метода
        // и вывести значения ее членов
        try{
            Class<?> c = ob.getClass();

            Method m = c.getMethod("myMeth");

            MyAnno anno = m.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc){
            System.out.println("method not found");
        }
    }

    public static void main(String args[]){

        myMeth();
    }
}
