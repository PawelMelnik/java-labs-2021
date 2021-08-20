package design_patterns.radio_alarm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RadioAlarmImpl implements RadioAlarm {

    private final Radio radio;
    private final Alarm alarm;

    @Override
    public void alarm() {
        alarm.alarm();
    }

    @Override
    public void playRadio() {
        radio.playRadio();
    }
}
