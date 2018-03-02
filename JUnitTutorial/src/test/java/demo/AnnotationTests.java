package demo;

import org.junit.*;

public class AnnotationTests {

    /**
     * До создания объекта класса
     */
    @BeforeClass
    public static void beforeClass(){
        System.out.println("This method has been executed first...");
    }

    // После удаления объекта класса
    @AfterClass
    public static void afterClass(){

        System.out.println("This method has been last...");
    }

    // Выполняется до теста. Генерация тестовых данных . Предустановка.
    @Before
    public void before(){

        System.out.println("Before each test");
    }
    // Выполняется после теста. Очистка ресурсов.
    @After
    public void after(){

        System.out.println("After each test");
    }
    // Сами тесты
    @Test
    public void simpleTest(){
        System.out.println("This is simple test");
    }

    @Ignore
    @Test
    public void ignoreTest(){
        System.out.println("This test will be ignored");
    }


}
