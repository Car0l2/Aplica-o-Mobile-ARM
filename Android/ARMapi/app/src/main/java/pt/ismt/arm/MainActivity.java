package pt.ismt.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Log;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log = (EditText) findViewById(R.id.entra);
        Login = (Button)findViewById(R.id.login);

    Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validate(Log.getText().toString());
        }
    });


    }
      //  EditText _texto = findViewById(R.id.txtValor);
      //  TextView  _resultado = findViewById(R.id.lblResultado);

     //   _resultado.setText("O utilizador escreveu "+_texto.getText().toString());
   // }
//if (savedInstanceState == null) {
    //    Log.d("estado", "onCreate: a activity vai ser criada pela 1ª vez...");
  //  } else {
   //     Log.d("estado", "onCreate: foi dada ordem para criar a activity novamente...");
   // }
     // Intent mudaActivity = new Intent(this, SegundaActivity.class);
     //        //startActivity(mudaActivity);
     //   // }
    private  void validate (String userName){




         if (userName.equals("staff")) {

             Intent entrarActivity = new Intent(this, FuncionarioActivity.class);
             startActivity(entrarActivity);
         }else if(userName.equals("sec")) {

             Intent entrarActivity = new Intent(this, SecretariaActivity.class);
             startActivity(entrarActivity);
         }else {



         }
     }



}
