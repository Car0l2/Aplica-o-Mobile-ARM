package pt.ismt.arm.ui.secactcrianca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ismt.arm.ApiConnection;
import pt.ismt.arm.R;
import pt.ismt.arm.ui.secdadoscriancas.SecDadosCriancasFragment;
import pt.ismt.arm.ui.seclistacriancas.SecListaCriancasFragment;


public class SecActCriancaFragment extends Fragment {
    private ApiConnection _api;
    private EditText txt_idade, txt_sala, txt_alergias, txt_restricao, txt_doenca, txt_contacto;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_sec_act_criancas, container, false);

        txt_idade = root.findViewById(R.id.txt_idade);
        txt_sala = root.findViewById(R.id.txt_sala);
        txt_alergias = root.findViewById(R.id.txt_alergias);
        txt_restricao = root.findViewById(R.id.txt_restricao);
        txt_doenca = root.findViewById(R.id.txt_doenca);
        txt_contacto = root.findViewById(R.id.txt_contacto);

        Button atualizar = (Button) root.findViewById(R.id.button13);

        atualizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //validação das caixas de texto
                if (txt_idade.getText().toString().length() == 0) {
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
                    String dados = "idade=" + txt_idade.getText() + "&sala=" + txt_sala.getText() + "&alergias=" + txt_alergias.getText() + "&restricao=" + txt_restricao.getText() + "&doenca_cronica=" + txt_doenca.getText() + "&contacto=" + txt_contacto.getText();

                    //executa o pedido à API
                    _api = new ApiConnection();
                    _api._activity = SecActCriancaFragment.this;
                    _api._listaCriancas = new ArrayList();
                    _api.execute("http://10.0.2.2:3001/api/v1/crianca/2", "2", dados);
                }

                SecDadosCriancasFragment secDadosCriancasFragment = new SecDadosCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secDadosCriancasFragment, secDadosCriancasFragment.getTag()).commit();
            }


        });

        return root;
    }

    public void sucessMessage() {
        Toast.makeText(getActivity(), "Aluno inserido com sucesso...", Toast.LENGTH_LONG).show();
        txt_idade.setText("");
        txt_sala.setText("");
        txt_alergias.setText("");
        txt_restricao.setText("");
        txt_doenca.setText("");
        txt_contacto.setText("");
    }
}