package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class StubTest2 {
    class MyTime {
        public int getHour() {
            return LocalTime.now().getHour();
        }
    }

    class StubTime12 extends MyTime {
        public int getHour() {
            return 12;
        }
    }

    class StubTime1 extends MyTime {
        public int getHour() {
            return 1;
        }
    }

    class AlarmClock {
        public MyTime timer;

        public AlarmClock(MyTime timer) {
            this.timer = timer;
        }

        public String fireAlarmWhenLunch() {
            if (timer.getHour() == 12) {
                return "An com thoi";
            }
            return "Chua den gio an";
        }
    }

    @Test
    public void thong_bao_khi_den_gio_an_trua() {
        AlarmClock alarmClock = new AlarmClock(new StubTime12());
        Assert.assertEquals("An com thoi", alarmClock.fireAlarmWhenLunch());
    }

    @Test
    public void thong_bao_khi_chua_den_gio_an_trua() {
        AlarmClock alarmClock = new AlarmClock(new StubTime1());
        Assert.assertEquals("Chua den gio an", alarmClock.fireAlarmWhenLunch());
    }
}
