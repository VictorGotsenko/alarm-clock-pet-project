package clock.states;

import clock.AlarmClock;

public class ClockMode implements State {
    private AlarmClock alarmClock;

    public ClockMode(AlarmClock a) {
        this.alarmClock = a;
        this.alarmClock.setCurrentMode("clock");
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
        if ((alarmClock.getAlarmMinutes() == curMin) && (alarmClock.getAlarmHours() == curHour)) {
            alarmClock.setAlarmTime(true);
        }
        // проверить может пора звонить?
        if (alarmClock.isAlarmOn() && alarmClock.isAlarmTime()) {
            // on Bell mode
            this.alarmClock.setState(new BellMode(this.alarmClock));
        }
    }

    @Override
    public final void clickH() {
        System.out.println("You click Hour-button");
        int currHour = alarmClock.getHours();
        if (currHour < 23) {
            ++currHour;
        } else {
            currHour = 0;
        }
        alarmClock.setHours(currHour);
    }

    @Override
    public final void clickM() {
        System.out.println("You click Minute-button");
        int currMinute = alarmClock.getMinutes();
        if (currMinute < 59) {
            ++currMinute;
        } else {
            currMinute = 0;
        }
        alarmClock.setMinutes(currMinute);
    }

    @Override
    public final void clickMode() {
        System.out.println("Change mode to Set Alarm");
        this.alarmClock.setState(new AlarmSetMode(this.alarmClock));
    }

    @Override
    public final void longClickMode() {
        alarmClock.setAlarmOn(!alarmClock.isAlarmOn());
        if (alarmClock.isAlarmOn()) {
            System.out.println("Alarm mode is On");
        } else {
            System.out.println("Alarm mode is Off");
        }
    }
}
