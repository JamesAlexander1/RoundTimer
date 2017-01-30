package a4336.a0.practise.james.roundtimer.Model;

import a4336.a0.practise.james.roundtimer.DTO.IDTO;
import android.os.CountDownTimer;
/**
 * Created by james on 24/1/17.
 */

public class TimerModel<String> implements ModelInterface<String> {

    CountDownTimer timer;
    public TimerModel(){

    }
    @Override
    public IDTO<String> getData() {
        return null;
    }

    @Override
    public boolean clean() {
        return false;
    }
}
