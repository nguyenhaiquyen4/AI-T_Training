package com.apress.prospring4.ch3.xml3_60;

public abstract class AbstractLookupDemoBean implements DemoBean {
    public abstract MyHelper getMyHelper();
    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}