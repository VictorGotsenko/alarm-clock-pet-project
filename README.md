## The Alarm clock
### This project is written in OOP style using the design pattern State.

### -= Task =-
Imagine an alarm clock.

![Alarm_clock](/src/img/Alarm_clock.png) 

#### Let it have three buttons:
* H - a button to increase the hour by one,
* M - to increase the minute by one, and a
* Mode button, which switches the watch to the alarm setting mode.

### Alarm clock modes:

1. **AlarmSetMode** - In this mode, the alarm time is displayed on the screen, and the H and M buttons set the alarm time.

- Pressing the Mode button again returns the watch to normal mode.

- In addition, pressing the Mode button for a long time activates the alarm.
               
- Pressing the Mode button again turns off the alarm.

2. **BellMode** - This mode is activated: if the alarm is active and the current time matches the alarm time, a bell is activated, which is turned off either by pressing the Mode button or spontaneously after a minute.

- The H and M buttons are not active in the bell mode (when the alarm has gone off).
           
### Let's sum it up. 
#### The alarm clock has the following actions:
- Setting the time
- Setting the alarm time
- Turning the alarm on/off
- Turning off the alarm
 

###### _Note_:  When using the H and M buttons, the hours and minutes change independently and do not affect each other in any way (as in most real alarm  clocks). That is, if the minutes increase from 59 to 60 (reset to 00), the number with the hours remains unchanged.           

#### Conclusion
The behavior of an alarm clock is already complex, since the same input actions (pressing the same buttons) initiate different actions depending on the mode. In software and hardware-software computing systems, entities with complex behavior are very common. Control devices, network protocols, dialog boxes, computer game characters, and many other objects and systems have this property.
           