package cesar.com.br.aula08_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TelaFinal extends AppCompatActivity {
    private int escolhida;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_final);

        TextView txtPorcentagem = (TextView)findViewById(R.id.textPorcentagem);

        Intent it = getIntent();
        Bundle params = it.getExtras();
        escolhida += params.getInt("valor5");

        porcentagem = (double)escolhida/5*100;
        txtPorcentagem.setText(""+(int)porcentagem + "%");

        final TextView result = (TextView)findViewById(R.id.textResultado);

        result.setText(""+escolhida);


        Button novo = (Button)findViewById(R.id.btnNovo);

        novo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaFinal.this, MainActivity.class);
                startActivity(it);


            }
        });

    }
}
