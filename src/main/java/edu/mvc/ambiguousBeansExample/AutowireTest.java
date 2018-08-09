package edu.mvc.ambiguousBeansExample;

import edu.mvc.ambiguousBeansExample.beans.Dessert;
import edu.mvc.ambiguousBeansExample.beans.Icy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AutowireTest {

    private Dessert dessert;
    private Dessert dessert2;
    private Dessert dessert3;

    private Logger logger;

    @Autowired
    public AutowireTest(Logger logger) {
        this.logger = logger;
    }

    @Autowired //First approach is to use Qualifier witch bean name - nor recommended - tightly coupled to class name
    public void setDessert(@Qualifier("cookies") Dessert dessert) {
        this.dessert = dessert;
        Objects.requireNonNull(dessert);
        logger.info("'Desert' injected? = " + dessert.getClass().getSimpleName());
    }

    @Autowired //Second approach is to annotate with @Primary
    public void setDessert2(Dessert dessert2) {
        this.dessert2 = dessert2;
        Objects.requireNonNull(dessert2);
        logger.info("'Desert2' injected? = " + dessert2.getClass().getSimpleName());
    }

    @Autowired //Third approach is to make new annotation and put it on desired component
    public void setDessert3(@Icy Dessert dessert3) {
        this.dessert3 = dessert3;
        Objects.requireNonNull(dessert3);
        logger.info("'Desert3' injected? = " + dessert3.getClass().getSimpleName());
    }
}
