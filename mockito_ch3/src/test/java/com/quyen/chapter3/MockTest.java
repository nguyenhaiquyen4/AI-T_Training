package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {
    class MyTime {
        public int getHour() {
            return LocalTime.now().getHour();
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

    @Mock
    MyTime timer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void thong_bao_khi_den_gio_an_trua() {
        AlarmClock alarmClock = new AlarmClock(timer);
        when(timer.getHour()).thenReturn(12);
        Assert.assertEquals("An com thoi", alarmClock.fireAlarmWhenLunch());
    }

    @Test
    public void thong_bao_khi_chua_den_gio_an_trua() {
        AlarmClock alarmClock = new AlarmClock(timer);
        when(timer.getHour()).thenReturn(1);
        Assert.assertEquals("Chua den gio an", alarmClock.fireAlarmWhenLunch());
    }
}
