package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    private static final double HIGH_PRESSURE_VALUE = 22.0;
    private static final double LOW_PRESSURE_VALUE = 16.0;
    private static final double NORMAL_PRESSURE_VALUE = 18.0;



    Alarm alarm;
    Sensor mockedSensor;

    @Before
    public void setUp() {
        this.mockedSensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(mockedSensor);
    }

    @Test
    public void testAlarmShouldTurnOnForLowPressure(){
        Mockito.when(this.mockedSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);

        alarm.check();

        assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void testAlarmShouldTurnOnForHighPressure(){
        Mockito.when(this.mockedSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);

        alarm.check();

        assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void testAlarmShouldBTurnedOffForNormalPressure(){
        Mockito.when(this.mockedSensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);

        alarm.check();

        assertFalse(alarm.getAlarmOn());

    }

}