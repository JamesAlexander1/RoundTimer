package a4336.a0.practise.james.roundtimer.Presenter;

import android.app.Activity;
import android.os.CountDownTimer;

import a4336.a0.practise.james.roundtimer.DAO.IDAO;
import a4336.a0.practise.james.roundtimer.DAO.TimerDAO;
import a4336.a0.practise.james.roundtimer.Model.ModelInterface;

/**
 * Created by james on 24/1/17.
 */

public class MainPresenter<Integer> extends AbstractPresenter<Integer> {

    Activity mainActivity;
    //ModelInterface<Integer> model;


    public MainPresenter(Activity main){
       mainActivity = main;

    }
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

        mainActivity = null;

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDAO<Integer> retrieveModel() {
        return null;
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


}
