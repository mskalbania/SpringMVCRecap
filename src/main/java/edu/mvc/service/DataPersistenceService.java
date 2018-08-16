package edu.mvc.service;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataPersistenceService {

    private Logger logger;
    private SessionFactory sessionFactory;

    @Autowired
    public DataPersistenceService(Logger logger, SessionFactory sessionFactory) {
        this.logger = logger;
        this.sessionFactory = sessionFactory;
    }
}
