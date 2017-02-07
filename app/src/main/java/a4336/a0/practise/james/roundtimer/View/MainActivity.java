package a4336.a0.practise.james.roundtimer.View;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import a4336.a0.practise.james.roundtimer.DTO.TimerDTO;
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
    private ToggleButton toggleBreakRoundsButton;

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

        toggleBreakRoundsButton = (ToggleButton) findViewById(R.id.toggleBreakButton);

        toggleBreakRoundsButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if(isChecked){
                    hiddenTable.setVisibility(View.VISIBLE);
                }else{
                    hiddenTable.setVisibility(View.INVISIBLE);
                }
            }



        });

        num_rounds_text = (EditText) findViewById(R.id.num_rounds_text);
        /*
        More textViews initalised.
         */
        length_rounds_text = (EditText) findViewById(R.id.Set_Length_Rounds_Text);
        length_break = (EditText) findViewById(R.id.L_of_B_R_View);
        num_of_rounds_per_break = (EditText) findViewById(R.id.N_of_B_R_View);

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
    public void onStartButtonPressed(){


        TimerDTO dto;
        String num_rounds = num_rounds_text.getText().toString();
        String length_rounds = length_rounds_text.getText().toString();
        String break_length = length_break.getText().toString();
        String num_rounds_before_break = num_of_rounds_per_break.getText().toString();

        /**
         * Check input with regex.
         */
        if(checkInput(num_rounds, length_rounds, break_length, num_rounds_before_break)){

            /**
             * encapsulate, send to TimerActivity.
             */

            String[] work_round_array = length_rounds.split(":");
            String[] break_round_array = break_length.split(":");
            System.out.println(work_round_array[0] + " " + work_round_array[1] + " " + num_rounds);
            dto = new TimerDTO(Integer.valueOf(num_rounds), Integer.valueOf(work_round_array[0]), Integer.valueOf(work_round_array[1]), Integer.valueOf(break_round_array[0]), Integer.valueOf(num_rounds_before_break));

            System.out.println("Integer: " + Integer.valueOf(num_rounds));
            Intent detailIntent = new Intent(MainActivity.this, TimerDisplayActivity.class);
            System.out.println(dto.getFields());
            detailIntent.putExtra("dto", dto);


            startActivity(detailIntent);

        }else{
            //Log Error. Ask user to alter input/
        }



        /*if(toggleBreakRoundsButton.isChecked()){
            //dto = new TimerDTO(num_rounds,break_length,0,0,0);

            System.out.println("round length as an Integer: " + length_rounds);
        }else{

        }*/

    }

    private boolean checkInput(String num_rounds, String length_rounds, String break_length, String num_rounds_before_break){

        boolean isCorrect = true;

        String TimeRegex = "^\\d:\\d\\d$";
        String numRegex = "^\\d+$";

        if(! (length_rounds.matches(TimeRegex) && break_length.matches(TimeRegex))){
            isCorrect = false;
        }
        if(! (num_rounds.matches(numRegex) && num_rounds_before_break.matches(numRegex))){
            isCorrect = false;
        }

        return isCorrect;
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

}
