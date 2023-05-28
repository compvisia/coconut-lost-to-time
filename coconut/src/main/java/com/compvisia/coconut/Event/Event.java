package com.compvisia.coconut.Event;

import org.jetbrains.annotations.NotNull;

public abstract class Event {
    private String name;

    @NotNull
    public final String getEventName() {
        if(name == null) name = getClass().getSimpleName();
        return name;
    }

    public abstract void execute() throws Exception;
}