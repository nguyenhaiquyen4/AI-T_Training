package com.apress.prospring4.ch11asyn;

import java.util.concurrent.Future;

public interface AsyncService {
    void asyncTask();

    Future<String> asyncWithReturn(String name);
}