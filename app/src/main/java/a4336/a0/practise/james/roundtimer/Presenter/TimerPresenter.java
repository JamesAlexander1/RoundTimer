package a4336.a0.practise.james.roundtimer.Presenter;

import android.app.Activity;
import android.os.CountDownTimer;

import a4336.a0.practise.james.roundtimer.DTO.IDTO;
import a4336.a0.practise.james.roundtimer.DTO.TimerDTO;
import a4336.a0.practise.james.roundtimer.View.TimerDisplayActivity;


/**
 * Created by james on 30/1/17.
 */

public class TimerPresenter<String> extends AbstractPresenter<String> {

    private TimerDTO model; //both dto and model.
    private TimerDisplayActivity thisActivity;
    private CountDownTimer timer;
    private Integer work_round_count;
    private Integer rounds_till_break;

    private final static Integer MINUTETOMILLISEC = 60000;
    private final static Integer SECONDTOMILLISEC = 1000;

    public TimerPresenter(TimerDisplayActivity activity, TimerDTO dto){

        thisActivity = activity;
        model = dto;

        work_round_count = model.getWork_rounds_number() - 1;
        rounds_till_break = model.getNum_of_work_rounds_before_break() - 1;
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

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDTO<String> retrieveModel() {
        return null;
    }

    public void startCountdownLoop(){



        while(work_round_count <= 0){

            /**
             * Work Round Setup
             */
            thisActivity.setTimerType();
            thisActivity.setTimer();
            while(rounds_till_break <= 0){

                /***
                 * DO NOT CALL. NEED TO RESEARCH LOCKS.. so that while loop does not complete until timer is finished.
                 */
                timer = new CountDownTimer(MINUTETOMILLISEC * model.getRound_minute(), SECONDTOMILLISEC ){


                    @Override
                    public void onTick(long millisUntilFinished) {
                        thisActivity.deincrementTimer();
                    }

                    @Override
                    public void onFinish() {
                        thisActivity.finishAndSetNextTimer();
                    }
                }.start();
            }
            /**
             * Break Round Setup.
             */
            thisActivity.setTimerType();
            thisActivity.setTimer();
        }
    }
}
