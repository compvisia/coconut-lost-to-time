package com.compvisia.coconut.Event.common;

import com.compvisia.coconut.Event.Event;
import com.compvisia.coconut.Event.EventExecutor;

public class WarningEvent extends Event {
    private final String message;

    public WarningEvent(String message) { this.message = message; }
    public String getMessage() { return message; }

    @Override
    public void execute() { EventExecutor.getListeners().forEach(l -> l.onWarning(this)); }
}
