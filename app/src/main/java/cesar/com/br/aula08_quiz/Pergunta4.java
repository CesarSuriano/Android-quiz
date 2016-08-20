package cesar.com.br.aula08_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pergunta4 extends AppCompatActivity {

    private int escolhida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta4);

        Intent it = getIntent();
        final Bundle params = it.getExtras();

        escolhida += params.getInt("valor3");

        final RadioGroup group = (RadioGroup)findViewById(R.id.grupo01);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                boolean alt4 = R.id.alt4 == checkedId;

                if(alt4){
                    escolhida += 1;
                }else{
                    escolhida = params.getInt("valor3");
                }

            }
        });

        Button seguinte = (Button)findViewById(R.id.btnSeguinte);

        seguinte.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Pergunta4.this, Pergunta5.class);
                Bundle params = new Bundle();
                params.putInt("valor4", escolhida);
                it.putExtras(params);


                startActivity(it);


            }
        });
    }
}
