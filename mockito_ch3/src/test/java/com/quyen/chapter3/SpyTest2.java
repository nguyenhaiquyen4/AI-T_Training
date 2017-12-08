package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Test;

public class SpyTest2 {
    class Worker {
        public void doJob() {
        }
    }

    class WorkerSpy extends Worker {
        public int count = 0;

        public void doJob() {
            count++;
            super.doJob();
        }
    }

    @Test
    public void count_the_number_of_invoke_getHomeLand() {
        WorkerSpy worker = new WorkerSpy();
        worker.doJob();
        worker.doJob();
        Assert.assertEquals(2, worker.count);
    }
}
