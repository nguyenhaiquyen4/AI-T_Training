package com.packt.legacy.unfavorable.construct.privates;

import com.packt.legacy.unfavorable.construct.constructor.GraphicalInterface;

public class PrivateMethodRefactored {
    public Object validate(Object arg) {
        if(arg == null) {
            showError("Null input");
        }
        return arg;
    }
    protected void showError(String msg) {
        GraphicalInterface.showMessage(msg);
    }
}
