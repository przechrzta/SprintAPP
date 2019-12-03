package com.example.sprintapp.shared;

import com.example.sprintapp.R;


public enum EventType {

    DIAGNOSTICS(R.string.diagnostics),
    ANNUAL_SAFETY_INSPECTION(R.string.annual_inspection),
    OIL_CHANGE(R.string.oil_change);


    private final int messageId;

    EventType(int messageId) {
        this.messageId = messageId;
    }

    public int getMessageId() {
        return messageId;
    }

}
