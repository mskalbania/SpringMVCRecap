package edu.mvc.config;

import edu.mvc.model.Post;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfig {

    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Post.class)
                .configure()
                .buildSessionFactory();
    }
}
