package cesar.com.br.aula08_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pergunta1 extends AppCompatActivity {


    private int escolhida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta1);

        Button seguinte = (Button)findViewById(R.id.btnSeguinte);

        final RadioGroup group = (RadioGroup)findViewById(R.id.grupo01);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                boolean alt2 = R.id.alt2 == checkedId;

                if(alt2){
                    escolhida = 1;
                }else{
                    escolhida = 0;
                }

            }
        });



        seguinte.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Pergunta1.this, Pergunta2.class);

                Bundle params = new Bundle();
                params.putInt("valor1", escolhida);

                it.putExtras(params);

                startActivity(it);


            }
        });
    }
}
