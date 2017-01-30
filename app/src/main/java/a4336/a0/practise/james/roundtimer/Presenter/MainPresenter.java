package a4336.a0.practise.james.roundtimer.Presenter;

import android.app.Activity;

import a4336.a0.practise.james.roundtimer.DTO.IDTO;

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
    public IDTO<Integer> retrieveModel() {
        return null;
    }




}
