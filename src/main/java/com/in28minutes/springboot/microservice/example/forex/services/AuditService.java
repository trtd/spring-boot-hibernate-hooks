package com.in28minutes.springboot.microservice.example.forex.services;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditService implements PreInsertEventListener, PreUpdateEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditService.class);

    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        LOGGER.info("onPreInsert");
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        LOGGER.info("onPreUpdate");
        return false;
    }
}
