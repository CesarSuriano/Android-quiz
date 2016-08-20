package cesar.com.br.aula08_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pergunta2 extends AppCompatActivity {
    private int escolhida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta2);

        Intent it = getIntent();
        final Bundle params = it.getExtras();

        escolhida += params.getInt("valor1");
        //Toast.makeText(Pergunta2.this, ""+escolhida, Toast.LENGTH_SHORT).show();

        final RadioGroup group = (RadioGroup)findViewById(R.id.grupo01);
        Button seguinte = (Button)findViewById(R.id.btnSeguinte);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                boolean alt3 = R.id.alt3 == checkedId;

                if(alt3){
                    escolhida += 1;
                }else{
                    escolhida = params.getInt("valor1");
                }

            }
        });

        seguinte.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Pergunta2.this, Pergunta3.class);
                Bundle params = new Bundle();
                params.putInt("valor2", escolhida);
                it.putExtras(params);
                startActivity(it);
            }
        });
    }
}
