package eu.codeacademy.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"eu.codeacademy.*"})
public class SpringContextConfig {

    //jeigu nededam anotacijos ant klases InternalMarksDao, galime pasirasyti tokia israiska
//    @Bean
//    public MarksDao marksDao(){
//        return new InternalMarksDao();
//    }

}
