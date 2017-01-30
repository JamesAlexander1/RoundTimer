package a4336.a0.practise.james.roundtimer.Presenter;

import a4336.a0.practise.james.roundtimer.DTO.IDTO;

/**
 * Created by james on 30/1/17.
 */

public abstract class AbstractPresenter<E> {




        public abstract void onStart();


        public abstract void onRestart();




        public abstract void onDestroy();




        public abstract void onPause();


        public abstract void onStop();

        public abstract void onResume();

        public abstract IDTO<E> retrieveModel();


}
