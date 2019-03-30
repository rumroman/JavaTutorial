package demo;

import mockito.QueryDescription;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Human.class)
public class HumanTests {

    @Mock()
    Human human2;



    private Human human;

    @Before
    public void setUp(){


        human = new Human();
        human.setName("Jack");
        human.setAge(22);
        human.setSpeciality("Java developer");
    }

    @Test
    public void testQuery() {

        //initMocks(this);

        human2.setAge(22);


        verify(human2).setAge(22);      // Проверяет вызывался ли метод setAge c памарметром 22.
        System.out.println(human2.getAge());
    }


    @Test
    public void checkGetterSetter(){

        assertEquals(22,human.getAge());
        assertEquals("Java developer",human.getSpeciality());
    }

    @Test
    public void checkExecutionOfMethods(){

        human = mock(Human.class);


        // define return value for method getAge();
        //verify(human).setName("");
        when(human2.getAge()).thenReturn(43);
        assertEquals(human2.getAge(),43);

        //human.setAge(22);
        //verify(human).setAge(22);
     }

     // demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue(){

        Iterator<String> i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        // assert
        assertEquals("Mockito rocks", result);
    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParametr(){
        Comparable<String> c = mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        // assert
        assertEquals(1, c.compareTo("Mockito"));
    }

    //this test demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnMethodParametr(){

        Comparable<Integer> c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(223429));

    }

    // return a value based on the type of the provide parameter

    @Test
    public void testReturnValueInDependentOnMethodParameter(){

        Comparable<Human> c = mock(Comparable.class);
        when(c.compareTo(isA(Human.class))).thenReturn(0);
        //assert
        assertEquals(0,c.compareTo(new Human()));

    }

    @Test
    public void testThrowExceptionInMethod(){

        Properties properties = mock(Properties.class);
        when(properties.get("Android")).thenThrow(new IllegalArgumentException("MyException"));

        try{
            properties.get("Android");
            fail("Android is misspelled");
        } catch(IllegalArgumentException ex){
            // good
        }
    }

    // "doReturn when" and "doThrow when" .
    @Test
    public void testDoReturnWhenAndDoThrowWhen(){

        Properties properties = new Properties();
        Properties spyProperties = spy(properties);

        doReturn("42").when(spyProperties).get("shoeSize"); //  Должно вернуться "42" , когда вызывается метод с параметром .get("shoeSize");

        String value = (String) spyProperties.get("shoeSize");
        assertEquals("42", value);

    }

    // Wrapping java objects with Spy
    @Test
    public void testLinkedListSpyWrong(){

        // Lets mock a LinkedList
        List<String> list = new LinkedList<>();
        List<String> listSpy = spy(list);

        listSpy.add("one");


        //this does not work
        // real method is called so spy.get(0)
        // throws IndexOutOfBoundsException (list is still empty)
        when(listSpy.get(0)).thenReturn("foo");

        assertEquals("foo",listSpy.get(0));
    }

    @Test
    public void testLinkedListSpyCorrect(){

        // Lets mock a LinkedList

        List<String> list = new LinkedList<>();
        List<String> listSpy = spy(list);

        //You have to use doReturn() for stubbing
        //doReturn("foo",listSpy.get(0));
    }

    @Test
    public void testVerify(){

        //create and configure mock
        Human test = Mockito.mock(Human.class);
        when(test.getAge()).thenReturn(43);

        assertEquals(43,test.getAge());

        test.getAge();
        test.getAge();
        test.getAge();
        test.getAge();

        // call method testing on the mock with parameter 12
        test.setAge(12);

        // now check if method testing was called with the parameter 12
        //verify(test).setAge(ArgumentMatchers.eq(12));

        // was the method called twice?                                                                         twice - дважды twice - дважды , twice - дважды
        verify(test,times(5)).getAge();                     // wanted Number of invocations - поиск количество вызовов.

        // other alternatives for verifying the number of method calls a method
        verify(test,never()).setSpeciality("never called");

        verify(test,atLeastOnce()).getAge();                         //called at least once(минимум один раз) . least - минимум,наименьшее, меньше

        verify(test,atLeast(2)).getAge();   //called at least twice

        verify(test,times(5)).getAge();    //called fives times

        verify(test,atMost(6)).getAge();        //called at most 3 times

        // This lets's you check that no other methods where called on this objects .
        // You call it after you have verified the expected method calls.

        verifyNoMoreInteractions(test);     // Проверяет нет ли не проверяемых вызовов методов объекта ссылающиеся на переменную test.

    }

    @Test
    public void testPrivateMethodSomeMethod() {

        Human spy = PowerMockito.spy(new Human());

        try {
            //PowerMockito.when(spy,method(Human.class,"someMethod",String.class))
             //       .withArguments("hello world!")
             //       .thenReturn("hello");
            PowerMockito.doReturn("hello world!").when(spy,"someMethod",anyString(),any(Sex.class));
           // System.out.println(spy.some(new Sex()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDefault()  {

        Human spy = PowerMockito.spy(new Human());
        List<String> list = new ArrayList<>();
        list.add("");

        try {


            PowerMockito.doReturn(list).when(spy,"queryDefault",any(String.class), any(QueryDescription.class), any(Class.class));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
