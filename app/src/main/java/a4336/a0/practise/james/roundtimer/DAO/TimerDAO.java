package a4336.a0.practise.james.roundtimer.DAO;

import java.sql.Time;
/**
 * Created by james on 23/1/17.
 *
 * Using java.util.Date and .sql.Time and not java.time as Android doesn't support Java 8 packages :/
 */

public class TimerDAO<Time> implements IDAO<Time> {

    Time time;

    public TimerDAO(Time newTime){
        time = newTime;
    }
    @Override
    public Time getFields() {
        return time;
    }
}
