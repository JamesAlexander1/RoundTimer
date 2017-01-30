package a4336.a0.practise.james.roundtimer.Model;


import a4336.a0.practise.james.roundtimer.DTO.IDTO;

public interface ModelInterface<E> {

    IDTO<E> getData();

    boolean clean();
}
