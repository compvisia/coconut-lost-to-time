package com.compvisia.coconut.Event;

import com.compvisia.coconut.Event.common.*;

public interface Listener {
    default void onError(ErrorEvent e) {}
    default void onException(ExceptionEvent e) {}
    default void onWarning(WarningEvent e) {}
}
