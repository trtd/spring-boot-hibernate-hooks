package com.in28minutes.springboot.microservice.example.forex;

import com.in28minutes.springboot.microservice.example.forex.services.AuditService;
import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class AuditServiceRegistry implements Integrator {

    private final AuditService auditService;

    public AuditServiceRegistry() {
        this.auditService = new AuditService();
    }

    @Override
    public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactoryImplementor,
                          SessionFactoryServiceRegistry serviceRegistry) {
        EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
        listenerRegistry.prependListeners(EventType.PRE_INSERT, auditService);
        listenerRegistry.prependListeners(EventType.PRE_UPDATE, auditService);
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactoryImplementor,
                             SessionFactoryServiceRegistry serviceRegistry) {

    }
}
