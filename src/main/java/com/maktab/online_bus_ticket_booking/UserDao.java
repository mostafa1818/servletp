package com.maktab.online_bus_ticket_booking;

import javax.persistence.EntityManager;

public class UserDao extends AbstractJpaDao<User,Integer> {

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
