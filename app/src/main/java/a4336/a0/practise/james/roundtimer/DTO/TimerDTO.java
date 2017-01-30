package a4336.a0.practise.james.roundtimer.DTO;


/**
 * may or may not use this.
 */

public class TimerDAO implements IDTO<String> {



    private Integer work_rounds_number;
    private Integer round_minute;
    private Integer round_sec_on_minute_left;


    private Integer break_round_length; //IN SECONDS ONLY AT THIS STAGE.

    private Integer num_of_work_rounds_before_break;

    public TimerDAO(Integer w_r_n, Integer r_m_l, Integer r_s_o_m_l, Integer b_r_l, Integer n_w_r_b_b){

        work_rounds_number = w_r_n;
        round_minute = r_m_l;
        round_sec_on_minute_left = r_s_o_m_l;
        break_round_length = b_r_l;
        num_of_work_rounds_before_break = n_w_r_b_b;
    }



    public Integer getWork_rounds_number() {
        return work_rounds_number;
    }

    public void setWork_rounds_number(Integer work_rounds_number) {
        this.work_rounds_number = work_rounds_number;
    }
    public Integer getRound_sec_on_minute_left() {
        return round_sec_on_minute_left;
    }

    public void setRound_sec_on_minute_left(Integer round_sec_on_minute_left) {
        this.round_sec_on_minute_left = round_sec_on_minute_left;
    }
    public Integer getRound_minute() {
        return round_minute;
    }

    public void setRound_minute(Integer round_minute_left) {
        this.round_minute = round_minute_left;
    }

    public Integer getNum_of_work_rounds_before_break() {
        return num_of_work_rounds_before_break;
    }

    public void setNum_of_work_rounds_before_break(Integer num_of_work_rounds_before_break) {
        this.num_of_work_rounds_before_break = num_of_work_rounds_before_break;
    }

    public Integer getBreak_round_length() {
        return break_round_length;
    }

    public void setBreak_round_length(Integer break_round_length) {
        this.break_round_length = break_round_length;
    }

    @Override
    public String getFields() {
        StringBuilder builder = new StringBuilder();
        builder.append(work_rounds_number);
        builder.append(" | " + round_minute);
        builder.append(" : " + round_sec_on_minute_left);

        /*
        add functionality for break rounds and num of work rounds before break.
         */

        return builder.toString();
    }
}

