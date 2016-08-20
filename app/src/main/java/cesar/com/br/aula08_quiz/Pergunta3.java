package cesar.com.br.aula08_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pergunta3 extends AppCompatActivity {

    private int escolhida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta3);

        Intent it = getIntent();
        final Bundle params = it.getExtras();
        escolhida += params.getInt("valor2");




        final RadioGroup group = (RadioGroup)findViewById(R.id.grupo01);
        Button seguinte = (Button)findViewById(R.id.btnSeguinte);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                boolean alt5 = R.id.alt5 == checkedId;

                if(alt5){
                    escolhida += 1;
                }else{
                    escolhida = params.getInt("valor2");
                }

            }
        });



        seguinte.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Pergunta3.this, Pergunta4.class);
                Bundle params = new Bundle();
                params.putInt("valor3", escolhida);
                it.putExtras(params);
                startActivity(it);
            }
        });
    }
}
