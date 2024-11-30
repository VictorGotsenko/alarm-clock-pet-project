package clock.states;

import clock.AlarmClock;

public class AlarmSetMode implements State {

    private AlarmClock alarmClock;

    public AlarmSetMode(AlarmClock a) {
        this.alarmClock = a;
        this.alarmClock.setCurrentMode("alarm");
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
        int alarmHour = alarmClock.getAlarmHours();
        if (alarmHour < 23) {
            ++alarmHour;
        } else {
            alarmHour = 0;
        }
        alarmClock.setAlarmHours(alarmHour);
    }

    @Override
    public final void clickM() {
        int alarmMinute = alarmClock.getAlarmMinutes();
        if (alarmMinute < 59) {
            ++alarmMinute;
        } else {
            alarmMinute = 0;
        }
        alarmClock.setAlarmMinutes(alarmMinute);
    }

    @Override
    public final void clickMode() {
        System.out.println("Change mode to Clock");
        this.alarmClock.setState(new ClockMode(this.alarmClock));
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
