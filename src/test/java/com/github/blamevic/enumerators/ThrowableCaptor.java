package com.github.blamevic.enumerators;

public class ThrowableCaptor {

    public interface Actor {
        void act() throws Throwable;
    }

    public static Throwable captureThrowable( Actor actor ) {
        Throwable result = null;
        try {
            actor.act();
        } catch( Throwable throwable ) {
            result = throwable;
        }
        return result;
    }
}
