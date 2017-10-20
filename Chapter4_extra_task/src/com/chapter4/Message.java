package com.chapter4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public final class Message implements Cloneable {
    public String sender;
    private ArrayList<String> recipients;
    private String text;

    public Message() {
        sender = "";
        text = "";
        recipients = new ArrayList<String>(1);
    }

    public Message(String sender){
        this.sender = sender;
        text = "";
        recipients = new ArrayList<String>(1);
    }

    public Message clone() throws CloneNotSupportedException {
        try {
            Message cloned = (Message)super.clone();
            @SuppressWarnings("unchecked")
            ArrayList<String> clonedRecipients = (ArrayList<String>)this.recipients.clone();
            cloned.recipients = clonedRecipients;
            cloned.sender = this.sender;
            cloned.text = this.text;
            return cloned;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
