package pt.ismt.arm.ui.secaddcriancas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import pt.ismt.arm.ApiConnection;
import pt.ismt.arm.R;
import pt.ismt.arm.ui.dadospessoais.DadosPessoaisFragment;
import pt.ismt.arm.ui.listacriancas.ListaCriancasFragment;
import pt.ismt.arm.ui.seclistacriancas.SecListaCriancasFragment;

public class SecaddCriancasFragment extends Fragment {
    private ApiConnection _api;
    private EditText txt_nome_c, txt_idade, txt_sala, txt_alergias, txt_restricao, txt_doenca, txt_contacto;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        View root = inflater.inflate(R.layout.fragment_sec_add_criancas, container, false);

        txt_nome_c = root.findViewById(R.id.txt_nome_c);
        txt_idade = root.findViewById(R.id.txt_idade);
        txt_sala = root.findViewById(R.id.txt_sala);
        txt_alergias = root.findViewById(R.id.txt_alergias);
        txt_restricao = root.findViewById(R.id.txt_restricao);
        txt_doenca = root.findViewById(R.id.txt_doenca);
        txt_contacto = root.findViewById(R.id.txt_contacto);

        Button inserir = (Button) root.findViewById(R.id.button13);

        inserir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //validação das caixas de texto
                if (txt_nome_c.getText().toString().length() == 0) {
                    txt_nome_c.setError("É necessário preencher o nome do aluno.");
                    txt_nome_c.requestFocus();
                } else if (txt_idade.getText().toString().length() == 0) {
                    txt_idade.setError("É necessário preencher o email do aluno.");
                    txt_idade.requestFocus();
                } else if (txt_sala.getText().toString().length() == 0) {
                    txt_sala.setError("É necessário preencher a morada do aluno.");
                    txt_sala.requestFocus();
                } else if (txt_alergias.getText().toString().length() == 0) {
                    txt_alergias.setError("É necessário preencher o telefone do aluno.");
                    txt_alergias.requestFocus();
                } else if (txt_restricao.getText().toString().length() == 0) {
                    txt_restricao.setError("É necessário preencher o telefone do aluno.");
                    txt_restricao.requestFocus();
                } else if (txt_doenca.getText().toString().length() == 0) {
                    txt_doenca.setError("É necessário preencher o telefone do aluno.");
                    txt_doenca.requestFocus();
                } else if (txt_contacto.getText().toString().length() == 0) {
                    txt_contacto.setError("É necessário preencher o telefone do aluno.");
                    txt_contacto.requestFocus();
                } else {
                    //dados a enviar para a API (formato BODY)
                    String dados = "nome_crianca=" + txt_nome_c.getText() + "&idade=" + txt_idade.getText() + "&sala=" + txt_sala.getText() + "&alergias=" + txt_alergias.getText() + "&restricao=" + txt_restricao.getText() + "&doenca_cronica=" + txt_doenca.getText() + "&contacto=" + txt_contacto.getText();

                    //executa o pedido à API
                    _api = new ApiConnection();
                    _api._activity = SecaddCriancasFragment.this;
                    _api._listaCriancas = new ArrayList();
                    _api.execute("http://10.0.2.2:3001/api/v1/crianca", "1", dados);
                }

                SecListaCriancasFragment secListaCriancasFragment = new SecListaCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secListaCriancasFragment, secListaCriancasFragment.getTag()).commit();
            }



        });





        return root;
    }
    public void sucessMessage() {
        Toast.makeText(getActivity(), "Aluno inserido com sucesso...", Toast.LENGTH_LONG).show();
        txt_nome_c.setText("");
        txt_idade.setText("");
        txt_sala.setText("");
        txt_alergias.setText("");
        txt_restricao.setText("");
        txt_doenca.setText("");
        txt_contacto.setText("");
    }
}



   /* public void inserirCrianca(View view)
    {
        //validação das caixas de texto
        if (txt_nome_c.getText().toString().length() == 0) {
            txt_nome_c.setError("É necessário preencher o nome do aluno.");
            txt_nome_c.requestFocus();
        } else if (txt_idade.getText().toString().length() == 0) {
            txt_idade.setError("É necessário preencher o email do aluno.");
            txt_idade.requestFocus();
        } else if (txt_sala.getText().toString().length() == 0) {
            txt_sala.setError("É necessário preencher a morada do aluno.");
            txt_sala.requestFocus();
        } else if (txt_alergias.getText().toString().length() == 0) {
            txt_alergias.setError("É necessário preencher o telefone do aluno.");
            txt_alergias.requestFocus();
        } else if (txt_restricao.getText().toString().length() == 0) {
            txt_restricao.setError("É necessário preencher o telefone do aluno.");
            txt_restricao.requestFocus();
        }else if (txt_doenca.getText().toString().length() == 0) {
            txt_doenca.setError("É necessário preencher o telefone do aluno.");
            txt_doenca.requestFocus();
        }else if (txt_contacto.getText().toString().length() == 0) {
            txt_contacto.setError("É necessário preencher o telefone do aluno.");
            txt_contacto.requestFocus();
        }else {
            //dados a enviar para a API (formato BODY)
            String dados = "nome=" + txt_nome_c.getText() + "&email=" + txt_idade.getText() + "&morada=" + txt_sala.getText() + "&telefone=" + txt_alergias.getText() + "&telefone=" +txt_restricao.getText() + "&telefone=" + txt_doenca.getText() + "&telefone=" + txt_contacto.getText();

            //executa o pedido à API
            _api= new ApiConnection();
            _api._activity = SecaddCriancasFragment.this;
            _api._listaCriancas =new ArrayList();
            _api.execute("http://10.0.2.2:3001/api/v1/crianca","1", dados);
        }
    }


}*/
/*public class InsertActivity extends AppCompatActivity {
    private ApiConnection _api;
    private EditText etNome, etEmail, etMorada, etTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etMorada = findViewById(R.id.etMorada);
        etTelefone = findViewById(R.id.etTelefone);
    }

    public void inserirAluno(View v)
    {
        //validação das caixas de texto
        if (etNome.getText().toString().length() == 0) {
            etNome.setError("É necessário preencher o nome do aluno.");
            etNome.requestFocus();
        } else if (etEmail.getText().toString().length() == 0) {
            etEmail.setError("É necessário preencher o email do aluno.");
            etEmail.requestFocus();
        } else if (etMorada.getText().toString().length() == 0) {
            etMorada.setError("É necessário preencher a morada do aluno.");
            etMorada.requestFocus();
        } else if (etTelefone.getText().toString().length() == 0) {
            etTelefone.setError("É necessário preencher o telefone do aluno.");
            etTelefone.requestFocus();
        } else {
            //dados a enviar para a API (formato BODY)
            String dados = "nome=" + etNome.getText() + "&email=" + etEmail.getText() + "&morada=" + etMorada.getText() + "&telefone=" + etTelefone.getText();

            //executa o pedido à API
            _api = new ApiConnection();
            _api._activity = InsertActivity.this;
            _api._listaAlunos = new ArrayList();
            _api.execute("http://10.0.2.2:3001/api/v1/aluno", "1", dados);
        }
    }

    public void voltarInicio(View v) {
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }

    public void sucessMessage() {
        Toast.makeText(this, "Aluno inserido com sucesso...", Toast.LENGTH_LONG).show();
        etNome.setText("");
        etEmail.setText("");
        etMorada.setText("");
        etTelefone.setText("");
    }
}*/