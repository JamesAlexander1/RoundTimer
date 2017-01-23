package a4336.a0.practise.james.roundtimer.Presenter;


import a4336.a0.practise.james.roundtimer.DAO.IDAO;


public interface PresenterInterface {
    public void onStart();


    public void onRestart();




    public void onDestroy();




    public void onPause();




    public void onResume();

    public IDAO retrieveModel();

}
