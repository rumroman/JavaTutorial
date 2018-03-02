                    Mockito.

В объектно- ориентированном программировани и mock объект имитирует поведение реального объекта заданным образом.
Во время unit - тестирования mock-объекты могут симулировать поведение бизнес-объектов и бизнес-логику , что иногда
необходимо из-за сложности реального поведелния.

Mock-библиотеки дают Java-разработчику удобство создания и использования тех самых mock-объектов!

mock-объект будет запоминать любые вызовы его методов, чтобы после Вы могли проверить какие методы вызывал ваш
тестируемый код у mock-объекта.

// mock -  объект
List mockedList = Mockito.mock(List.class);

// используем его
mockedList.add("one");
mockedList.clear();

//проверяем, были ли вызваны методы add  с параметрами "one" и метод clear.
Mockito.verify(mockedList).add("one");
Mockito.verify(mockedList).clear();

По умолчанию все методы mock объекта возвращают default'ные значения.

//stub'инг

when(mockedList.get(0)).thenReturn("first");

when(mockedList.get(1)).thenThrow(new RuntimeException());

//получим first
System.out.println(mockedList.get(0));

//получим RuntimeException
System.out.println(mockedList.get(1));

//получим "null" ибо get(999) не был определен
System.out.println(mockedList.get(999));