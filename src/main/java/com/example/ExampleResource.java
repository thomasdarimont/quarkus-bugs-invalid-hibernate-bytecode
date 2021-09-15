package com.example;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/hello")
public class ExampleResource {

    private final EntityManager em;

    public ExampleResource(EntityManager em) {
        this.em = em;
    }

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        var drink = new Drink();
        drink.setName("Cola");

        em.persist(drink);

        em.flush();

        return Arrays.toString(em.createQuery("from Drink").getResultList().toArray());
    }
}