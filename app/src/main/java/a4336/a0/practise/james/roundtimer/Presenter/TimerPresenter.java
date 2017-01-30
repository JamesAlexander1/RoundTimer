package a4336.a0.practise.james.roundtimer.Presenter;

import a4336.a0.practise.james.roundtimer.DTO.IDTO;
import a4336.a0.practise.james.roundtimer.DTO.TimerDAO;

/**
 * Created by james on 30/1/17.
 */

public class TimerPresenter<String> extends AbstractPresenter<String> {


    public TimerPresenter(){

    }
    public boolean setAllTimers(TimerDAO timerDAO){
        /**
         * TimerDAO class should use interface variable instead.
         */
        setWorkRoundTimer(timerDAO.getWork_rounds_number(), timerDAO.getNum_of_work_rounds_before_break(), timerDAO.getRound_minute(), timerDAO.getRound_sec_on_minute_left());
        setBreakRoundTimer(timerDAO.getBreak_round_length());
        return true;
    }
    private void setWorkRoundTimer(int num_rounds,int num_groups, int minute_per_round, int seconds){}
    private void setBreakRoundTimer(int seconds){}
    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDTO<String> retrieveModel() {
        return null;
    }
}
