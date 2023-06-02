package com.compvisia.coconut.Event.common;

import com.compvisia.coconut.Event.Event;
import com.compvisia.coconut.Event.EventExecutor;

public class ExceptionEvent extends Event {

    private final Exception e;

    public ExceptionEvent(Exception e) { this.e = e; }
    public Exception getException() { return e; }

    @Override
    public void execute() { EventExecutor.getListeners().forEach(l -> l.onException(this)); }
}
