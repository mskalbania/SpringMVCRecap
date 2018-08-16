package edu.mvc.service;

import edu.mvc.exception.InvalidPostException;
import edu.mvc.exception.InvalidRangeException;
import edu.mvc.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsPersistenceService {

    private Logger logger;
    private SessionFactory sessionFactory;

    @Autowired
    public PostsPersistenceService(Logger logger, SessionFactory sessionFactory) {
        this.logger = logger;
        this.sessionFactory = sessionFactory;
    }

    public Post save(Post post) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String id = (String) session.save(post);
            session.getTransaction().commit();
            post.setId(id);
            return post;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new InvalidPostException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Post> get(Integer min, Integer max) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List posts = session.createQuery("from Post").list();
            session.getTransaction().commit();
            return posts.subList(min, max + 1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new InvalidRangeException("Index is invalid.");
        }
    }
}
