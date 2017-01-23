package a4336.a0.practise.james.roundtimer.Model;


import a4336.a0.practise.james.roundtimer.DAO.IDAO;

public interface ModelInterface<E> {

    IDAO<E> getData();

    boolean clean();
}
