package ch.jstollutions;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class TestScheduleBean {
    @Schedule(hour = "23", minute = "55")
    void scheduleMe() {
    }
}