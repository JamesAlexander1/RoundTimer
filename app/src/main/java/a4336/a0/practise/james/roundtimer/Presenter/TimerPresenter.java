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
    private Integer total_round_count;
    private Integer work_round_group_count;

    private boolean timerActive = false;
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

        if(timerActive == true){
            timerActive = false;
            timer.cancel();
        }
        if(model != null){
            model = null;
        }
        if(thisActivity != null){
            thisActivity = null;
        }

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {
        timer.cancel();
        timerActive = false;
        model = null;
        thisActivity = null;

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDTO<String> retrieveModel() {
        return null;
    }

    public void startBreakRound(){

        timerActive = true;
        work_round_group_count = 0;

        timer = new CountDownTimer(MINUTETOMILLISEC * model.getBreak_round_length(), SECONDTOMILLISEC ){


            @Override
            public void onTick(long millisUntilFinished) {
                thisActivity.deincrementTimer();
            }

            @Override
            public void onFinish() {
                thisActivity.finishAndSetNextTimer();

                timerActive = false;

                checkAndControlRounds();
            }
        }.start();
        // thisActivity.setTimerType(true);
        //thisActivity.setTimer((MINUTETOMILLISEC * model.getBreak_minute() + seconds));

    }
    public void startWorkRound(){
        timerActive = true;

        Integer seconds = model.getRound_sec_on_minute_left();
        seconds = seconds * SECONDTOMILLISEC;


        timer = new CountDownTimer(MINUTETOMILLISEC * model.getRound_minute() + seconds, SECONDTOMILLISEC ){


            @Override
            public void onTick(long millisUntilFinished) {
                thisActivity.deincrementTimer();

            }

            @Override
            public void onFinish() {


                thisActivity.finishAndSetNextTimer();
                timerActive = false;
                total_round_count ++;
                work_round_group_count ++;

                checkAndControlRounds();
            }

        }.start();
       // thisActivity.setTimerType(true);
        //thisActivity.setTimer((MINUTETOMILLISEC * model.getRound_minute() + seconds));
    }

    public void checkAndControlRounds(){


            if (total_round_count == (model.getWork_rounds_number() * model.getNum_of_work_rounds_before_break())) {

                //Finish Timer.
                thisActivity.finish();

            } else if (work_round_group_count == rounds_till_break) {


                //Start BreakRound, then start another work round
                startBreakRound();
            } else {

                //Start another work round
                startWorkRound();
            }

    }
    public void startCountdownLoop(){

        total_round_count = 0;
        work_round_group_count = 0;

        startWorkRound();

    }
}
