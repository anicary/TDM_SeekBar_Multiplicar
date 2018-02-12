package mx.edu.ittepic.multiplicador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button mult;
EditText valor;
SeekBar barra;
    TextView result,pos;
    int multi=0;
    String valores="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mult = findViewById(R.id.mult);
        result = findViewById(R.id.result);
        barra = findViewById(R.id.seekBar);
        pos=findViewById(R.id.multiplicador);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                multi=progress;
                pos.setText(""+multi);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valores="";
                for(int i=1; i<=30;i++){
                    valores+=""+i+"*"+multi+"="+(multi*i)+"\n";
                }
                result.setText(valores);
            }
        });
    }
}
