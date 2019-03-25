package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    private TrainController controller;
    private TrainUser user;
    private TrainSensorImpl sensor;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }
    @Test
    public void changeSpeedOver(){
        sensor.overrideSpeedLimit(600);
        verify(user).setAlarmState(true);
    }
    @Test
    public void changeSpeedUnderZero(){
        sensor.overrideSpeedLimit(-1);
        verify(user).setAlarmState(true);
    }
    @Test
    public void changeSpeedUnderReference(){
        when(controller.getReferenceSpeed()).thenReturn(90);
        sensor.overrideSpeedLimit(90 / 3);
        verify(user).setAlarmState(true);
    }
    @Test
    public void doNotChangeAlarmState(){
        when(controller.getReferenceSpeed()).thenReturn(300);
        sensor.overrideSpeedLimit(300);
        verify(user).setAlarmState(false);
    }
}
