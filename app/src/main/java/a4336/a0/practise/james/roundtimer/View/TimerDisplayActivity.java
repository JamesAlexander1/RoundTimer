package a4336.a0.practise.james.roundtimer.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import a4336.a0.practise.james.roundtimer.DTO.TimerDTO;
import a4336.a0.practise.james.roundtimer.Presenter.AbstractPresenter;
import a4336.a0.practise.james.roundtimer.Presenter.TimerPresenter;
import a4336.a0.practise.james.roundtimer.R;

public class TimerDisplayActivity extends AppCompatActivity {

    private AbstractPresenter<String> presenter;
    private boolean timerType;  //true = work round, false = break round.

    private EditText timerNumDisplay;
    private TextView timerTypeDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_display);

        Button backButton = (Button) findViewById(R.id.Quit_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        timerTypeDisplay = (TextView) findViewById(R.id.round_number_view);
        timerNumDisplay = (EditText) findViewById(R.id.Timer_Display_EditText);

        TimerDTO settings = (TimerDTO) getIntent().getSerializableExtra("dto");
        presenter = new TimerPresenter<>(this, settings);



    }

    @Override
    protected void onStart() {

        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        presenter.onRestart();
    }

    @Override
    protected void onDestroy() {


        super.onDestroy();

        presenter.onDestroy();
        presenter = null;
    }

    @Override
    protected void onPause() {

        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
        presenter.onStop();


    }


    /**
     *
     * USE TIMEUNIT java.util stuff to convert from milliseconds to minutes and seconds.
     */

    public void setTimer(String timerLength){}
    public void deincrementTimer(){}
    public void setTimerType(boolean isWorkRound){}
    public void finishAndSetNextTimer(){}



}
