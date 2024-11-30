package clock.states;

import clock.AlarmClock;

public class BellMode implements State {
    private AlarmClock alarmClock;

    public BellMode(AlarmClock a) {
        this.alarmClock = a;
        this.alarmClock.setCurrentMode("bell");
    }

    @Override
    public final void tick() {
        int curHour = alarmClock.getHours();
        int curMin = alarmClock.getMinutes();
        if (curMin < 59) {
            ++curMin;
        } else {
            curMin = 0;
            if (curHour < 23) {
                ++curHour;
            } else {
                curHour = 0;
            }
        }
        alarmClock.setHours(curHour);
        alarmClock.setMinutes(curMin);
        System.out.println("Change mode toClock");
        this.alarmClock.setState(new ClockMode(this.alarmClock));
    }

    @Override
    public final void clickH() {
        System.out.println("Buttom is disable");
    }

    @Override
    public final void clickM() {
        System.out.println("Buttom is disable");
    }

    @Override
    public final void clickMode() {
        System.out.println("Change mode to Clock");
        this.alarmClock.setState(new ClockMode(this.alarmClock));
    }

    @Override
    public void longClickMode() {

    }
}
