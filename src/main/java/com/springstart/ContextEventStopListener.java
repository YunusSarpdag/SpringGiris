package com.springstart;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ContextEventStopListener extends ApplicationEvent implements ApplicationListener<ContextStoppedEvent> {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ContextEventStopListener(Object source) {
        super(source);
    }

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("event destroy listener");
    }
}
