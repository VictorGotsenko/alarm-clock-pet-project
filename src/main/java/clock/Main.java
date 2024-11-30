package clock;

public class Main {
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock();
        clock.tick();
        System.out.println(clock.getHours() + " : " + clock.getMinutes());
        clock.tick();
        System.out.println(clock.getHours() + " : " + clock.getMinutes());
        clock.tick();
        System.out.println(clock.getHours() + " : " + clock.getMinutes());
        clock.tick();
        System.out.println(clock.getHours() + " : " + clock.getMinutes());
        clock.clickMode();
        clock.longClickMode();
        clock.longClickMode();

    }
}
