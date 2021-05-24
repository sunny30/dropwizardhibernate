package io.com.dropwizard.entity.dao;

import io.com.dropwizard.entity.GuestEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GuestEntityDAO extends AbstractDAO<GuestEntity> {

    public GuestEntityDAO(SessionFactory sessionFactory){
        super(sessionFactory);

    }

    public GuestEntity findById(Long id) {

        Query<GuestEntity> query = namedQuery( "io.com.dropwizard.entity.findById").
                setParameter("id",id);
        return query.getSingleResult() ;
    }


    public List<GuestEntity> findAll(){
        return list(namedQuery( "io.com.dropwizard.entity.findAll")) ;
    }

    public GuestEntity create(GuestEntity entity){
         return persist(entity) ;
    }

}
