package mx.edu.ittepic.multiplicador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mult;
    EditText valor;
    SeekBar barra;
    TextView result,pos;
    ListView lista;
    int multi=0;
    String valores="";

    ArrayList<String> listaitems;
    ArrayAdapter<String> adadptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);
        barra = findViewById(R.id.seekBar);
        pos=findViewById(R.id.multiplicador);
        generar(1);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                multi=progress;
                pos.setText(""+multi);
                listaitems=new ArrayList<String>();
                valores="";
                for(int i=0; i<10;i++){

                    valores=""+(i+1)+"*"+multi+"="+(multi*(i+1))+"";
                    listaitems.add(""+valores);
                }
                adadptador=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listaitems);
                lista.setAdapter(adadptador);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    public void generar(int multi){
        listaitems=new ArrayList<String>();
        valores="";
        for(int i=0; i<10;i++){
            valores=""+(i+1)+"*"+multi+"="+(multi*(i+1))+"";
            listaitems.add(""+valores);
        }
        adadptador=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listaitems);
        lista.setAdapter(adadptador);
    }
}