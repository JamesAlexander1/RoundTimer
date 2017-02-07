package a4336.a0.practise.james.roundtimer.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a4336.a0.practise.james.roundtimer.DTO.TimerDTO;
import a4336.a0.practise.james.roundtimer.R;

public class TimerDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_display);

        Button backButton = (Button) findViewById(R.id.Quit_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TimerDTO settings = (TimerDTO) getIntent().getSerializableExtra("dto");

        System.out.println(settings.getFields());


    }



}
