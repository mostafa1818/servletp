package com.maktab.online_bus_ticket_booking;

import javax.persistence.EntityManager;

public class TravelDao extends AbstractJpaDao<Travel,Integer> {

    public TravelDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }
}
