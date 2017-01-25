package a4336.a0.practise.james.roundtimer.Presenter;


import a4336.a0.practise.james.roundtimer.DAO.IDAO;


public interface PresenterInterface<E> {
    public void onStart();


    public void onRestart();




    public void onDestroy();




    public void onPause();


    public void onStop();

    public void onResume();

    public IDAO<E> retrieveModel();

}
