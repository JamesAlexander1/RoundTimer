package a4336.a0.practise.james.roundtimer.Model;

import a4336.a0.practise.james.roundtimer.DAO.IDAO;

/**
 * Created by james on 24/1/17.
 */

public class TimerModel<Timer> implements ModelInterface<Timer> {

    public TimerModel(){

    }
    @Override
    public IDAO<Timer> getData() {
        return null;
    }

    @Override
    public boolean clean() {
        return false;
    }
}
