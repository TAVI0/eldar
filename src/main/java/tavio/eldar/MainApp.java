package tavio.eldar;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppConfig.class, args);
        Features features = context.getBean(Features.class);
        features.process();
    }
}