package a4336.a0.practise.james.roundtimer.View;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import a4336.a0.practise.james.roundtimer.Model.TimerModel;
import a4336.a0.practise.james.roundtimer.Presenter.AbstractPresenter;
import a4336.a0.practise.james.roundtimer.Presenter.MainPresenter;
import a4336.a0.practise.james.roundtimer.R;

public class MainActivity extends AppCompatActivity {


    private AbstractPresenter<Integer> presenter;

    private TextView num_rounds_text;
    private TextView length_rounds_text;
    private TextView length_break;
    private TextView num_of_rounds_per_break;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Initialise();
        InitialiseButtonsAndViews();
    }

    private void Initialise(){

        presenter = new MainPresenter(this);
    }
    private void InitialiseButtonsAndViews(){

        final TableLayout hiddenTable = (TableLayout) findViewById(R.id.Hidden_Table);
        hiddenTable.setVisibility(View.INVISIBLE);

        ToggleButton toggleBreakRoundsButton = (ToggleButton) findViewById(R.id.toggleBreakButton);

        toggleBreakRoundsButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if(isChecked){
                    hiddenTable.setVisibility(View.VISIBLE);
                }else{
                    hiddenTable.setVisibility(View.INVISIBLE);
                }
            }



        });

        num_rounds_text = (TextView) findViewById(R.id.Set_Length_Rounds_Text);
        /*
        More textViews initalised.
         */

        Button startButton = (Button) findViewById(R.id.Start_Button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * call onStartButtonPressed. Pass Timer config to TimerActivity.
                 */
                onStartButtonPressed();
            }
        });
    }

    /**
     * On Start Button Pressed. Take Information, encapsulate in DTO. Move to TimerActivity and onto presenter.
     */
    public void onStartButtonPressed(){}

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

}
