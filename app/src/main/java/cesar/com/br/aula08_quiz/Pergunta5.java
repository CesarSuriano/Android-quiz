package cesar.com.br.aula08_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pergunta5 extends AppCompatActivity {

    private int escolhida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta5);

        Intent it = getIntent();
        final Bundle params = it.getExtras();

        escolhida += params.getInt("valor4");

        final RadioGroup group = (RadioGroup)findViewById(R.id.grupo01);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                boolean alt1 = R.id.alt1 == checkedId;

                if(alt1){
                    escolhida += 1;
                }else{
                    escolhida = params.getInt("valor4");
                }

            }
        });

        Button seguinte = (Button)findViewById(R.id.btnSeguinte);

        seguinte.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Pergunta5.this, TelaFinal.class);
                Bundle params = new Bundle();
                params.putInt("valor5", escolhida);
                it.putExtras(params);
                startActivity(it);
            }
        });
    }
}
