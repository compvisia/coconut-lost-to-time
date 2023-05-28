package com.compvisia.coconut.Event;

import com.compvisia.coconut.Event.common.ExceptionEvent;

import java.util.ArrayList;
import java.util.List;

public class EventExecutor {

    private static final List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener l) { listeners.add(l); }
    public void callEvent(Event e) {

        try { e.execute(); }
        catch(Exception ex) { new ExceptionEvent(ex).execute(); }
    }

    public static List<Listener> getListeners() { return listeners; }

}
