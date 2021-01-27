package com.maktab.online_bus_ticket_booking;

import javax.persistence.EntityManager;

public class TiketDao extends AbstractJpaDao<Tiket,Integer> {

    public TiketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Tiket> getEntityClass() {
        return Tiket.class;
    }
}
