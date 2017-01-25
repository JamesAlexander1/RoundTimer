package a4336.a0.practise.james.roundtimer.Presenter;

import java.util.Timer;

import a4336.a0.practise.james.roundtimer.DAO.IDAO;
import a4336.a0.practise.james.roundtimer.Model.ModelInterface;

/**
 * Created by james on 24/1/17.
 */

public class MainPresenter<Timer> implements PresenterInterface<Timer> {

    ModelInterface<Timer> model;

    public MainPresenter(ModelInterface paramModel){
        model = paramModel;
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

        if(model.clean()){
            model = null;
        }else{
            // Handle Exception.
        }

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDAO<Timer> retrieveModel() {
        return null;
    }
}
