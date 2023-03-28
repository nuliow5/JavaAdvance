package eu.codeacademy.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class InnerClass2 {
    private String name;
    protected String nr;
    int sk;

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    class Internal{
        int sk;
        void print(){
            System.out.println("Hello from Internal class");
            System.out.println("sk -> " + sk);
        }
    }

}
