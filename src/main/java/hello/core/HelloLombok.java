package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok hello = new HelloLombok();

        //setter / getter 함수를 만들지 않았지만 Lombok 라이브러리를 사용하면 내부적으로 자동으로 만들어준다.
        hello.setName("Ha kisung");
        hello.setAge(48);

        String MyName = hello.getName();

        System.out.println("MyName: " + MyName);
        System.out.println("MyAge: " + hello.getAge());
        System.out.println("toString: " + hello.toString());


    }
}
