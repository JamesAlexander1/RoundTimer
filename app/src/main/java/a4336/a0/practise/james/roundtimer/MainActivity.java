package a4336.a0.practise.james.roundtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }

    private void Initialise(){

        presenter = new MainPresenter(new TimerModel());
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
