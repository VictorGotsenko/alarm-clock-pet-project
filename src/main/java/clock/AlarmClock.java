package clock;

import lombok.Getter;
import lombok.Setter;
import clock.states.ClockMode;
import clock.states.State;

@Getter
@Setter
public class AlarmClock implements State {

    private State state;

    private String currentMode;
    private int hours;
    private int minutes;

    private int alarmHours;
    private int alarmMinutes;
    private boolean isAlarmOn;
    private boolean isAlarmTime;


    public AlarmClock() {
        this.currentMode = "clock";
        this.hours = 12;
        this.minutes = 0;
        this.alarmHours = 6;
        this.alarmMinutes = 0;
        this.isAlarmOn = false;
        this.isAlarmTime = false;

        this.state = new ClockMode(this);  //getCurrentMode()).isEqualTo("clock");
    }

    @Override
    public final void tick() {
        state.tick();
    }

    @Override
    public final void clickH() {
        state.clickH();
    }

    @Override
    public final void clickM() {
        state.clickM();
    }

    @Override
    public final void clickMode() {
        state.clickMode();
    }

    @Override
    public final void longClickMode() {
        state.longClickMode();
    }
}
