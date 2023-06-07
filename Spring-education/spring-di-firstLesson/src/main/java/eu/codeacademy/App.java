package eu.codeacademy;

import eu.codeacademy.config.SpringContextConfig;
import eu.codeacademy.dao.InternalMarksDao;
import eu.codeacademy.service.GradeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        diExampleWithSpringContext();
    }

    private static void diExampleWithSpringContext(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfig.class);
        final GradeService gradeService = context.getBean(GradeService.class);
        System.out.println("Pazymiu vidurkis: " + gradeService.averageGrade());
    }

    private static void simplePlainJavaDIExample() {
        System.out.println(new GradeService(new InternalMarksDao()).averageGrade());
    }

}
