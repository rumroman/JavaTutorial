package general.tutorial.java8.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String args[]){

        Optional<String> noVal = Optional.empty();

        Optional<String> hasVal = Optional.of("ABCDEFG");

        if(noVal.isPresent()) System.out.println("Не подлежит выводу");
        else System.out.println("Объект noVal не содержит значение");

        hasVal.ifPresent(s -> System.out.println(
                "Объект hasVal содрежит следующую строку: " + s));

        String defStr = noVal.orElse("Строка по умолчанию");
        System.out.println(defStr);

    }

    /**
     *
     * Значение может быть получно из объекта типа Optional только в том случае,
     * если он присутствует в нем. Этот элементарный механизм позволяет предотвра-
     * тить исключения, возникающие в классе Optional в связи с пустыми указателями.
     *    Аналогичным образом действуют классы OptianlDouble, OptionalInt,
     * OptionalLong.
     */
}
