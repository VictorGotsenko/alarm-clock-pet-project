package clock.states;

public interface State {
    /*
    Интерфейсными методами часов являются:
        clickMode() - нажатие на кнопку Mode
        longClickMode() - долгое нажатие на кнопку Mode
        clickH() - нажатие на кнопку H
        clickM() - нажатие на кнопку M
        tick() - при вызове, увеличивает время на одну минуту.
        Если новое время совпало со временем на будильнике,
        то часы переключаются в режим срабатывания будильника (bell).
     */
    void tick();
    void clickH();
    void clickM();
    void clickMode();
    void longClickMode();

}
