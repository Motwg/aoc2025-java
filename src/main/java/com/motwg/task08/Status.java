package com.motwg.task08;

public enum Status {
    CONNECTED {
        @Override
        public boolean isConnected() {return true;}
    },
    DISCONNECTED;

    public boolean isConnected() {return false;}
}
