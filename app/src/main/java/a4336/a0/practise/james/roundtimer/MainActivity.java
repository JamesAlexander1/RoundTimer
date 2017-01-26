package a4336.a0.practise.james.roundtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.ToggleButton;

import a4336.a0.practise.james.roundtimer.Model.TimerModel;
import a4336.a0.practise.james.roundtimer.Presenter.MainPresenter;
import a4336.a0.practise.james.roundtimer.Presenter.PresenterInterface;

public class MainActivity extends AppCompatActivity {


    private PresenterInterface presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Initialise();
        InitialiseButtonsAndViews();
    }

    private void Initialise(){

        presenter = new MainPresenter(new TimerModel());
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
