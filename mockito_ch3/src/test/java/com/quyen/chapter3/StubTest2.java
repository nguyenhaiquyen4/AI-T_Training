package com.quyen.chapter3;

import java.util.Date;

public class StubTest2 {
    class DummyClock extends Date {
        @Override
        public int hashCode() {
            return 100;
        }
    }
}
