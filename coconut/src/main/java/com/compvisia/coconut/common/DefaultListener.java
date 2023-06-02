package com.compvisia.coconut.common;

import com.compvisia.coconut.Event.EventExecutor;
import com.compvisia.coconut.Event.Listener;
import com.compvisia.coconut.Event.common.ErrorEvent;
import com.compvisia.coconut.Event.common.ExceptionEvent;
import com.compvisia.coconut.Event.common.WarningEvent;

public class DefaultListener implements Listener {

    public static boolean isListening = true;
    public static boolean onError = true, onException = true, onWarning = true;

    public DefaultListener() {
        EventExecutor.addListener(this);
    }

    public void onError(ErrorEvent e) {
        if(!isListening || !onError) return;

        System.err.println(e.getMessage());
    }

    public void onException(ExceptionEvent e) {
        if(!isListening || !onException) return;

        e.getException().printStackTrace();
    }

    public void onWarning(WarningEvent e) {
        if(!isListening || !onWarning) return;

        System.out.println(e.getMessage());
    }
}
