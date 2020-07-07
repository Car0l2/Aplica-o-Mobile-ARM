package pt.ismt.arm.ui.secdadoscriancas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;

import pt.ismt.arm.ApiConnection;
import pt.ismt.arm.R;
import pt.ismt.arm.ui.secactcrianca.SecActCriancaFragment;
import pt.ismt.arm.ui.seclistacriancas.SecListaCriancasFragment;

public class SecDadosCriancasFragment extends Fragment {

    ListView ld;
    ApiConnection _api;
    private EditText txt_nome_c, txt_idade, txt_sala, txt_alergias, txt_restricao, txt_doenca, txt_contacto;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_dados_criancas, container, false);

        txt_nome_c = root.findViewById(R.id.txt_nome_c);
        txt_idade = root.findViewById(R.id.txt_idade);
        txt_sala = root.findViewById(R.id.txt_sala);
        txt_alergias = root.findViewById(R.id.txt_alergias);
        txt_restricao = root.findViewById(R.id.txt_restricao);
        txt_doenca = root.findViewById(R.id.txt_doenca);
        txt_contacto = root.findViewById(R.id.txt_contacto);


        ld = root.findViewById(R.id.listdados);

        _api = new ApiConnection();
        _api._activity = SecDadosCriancasFragment.this;
        _api._listaCriancas = new ArrayList();
        _api.execute("http://10.0.2.2:3001/api/v1/crianca/12", "0");

        Button listcriact = (Button) root.findViewById(R.id.listfunadd);
        listcriact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecActCriancaFragment secActCriancaFragment = new SecActCriancaFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secActCriancaFragment, secActCriancaFragment.getTag()).commit();

            }
        });

        Button delete = (Button) root.findViewById(R.id.button14);

        delete.setOnClickListener(new View.OnClickListener() {
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
                    _api._activity = SecDadosCriancasFragment.this;
                    _api._listaCriancas = new ArrayList();
                    _api.execute("http://10.0.2.2:3001/api/v1/crianca/12", "3", dados);
            }

                SecListaCriancasFragment secListaCriancasFragment = new SecListaCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secListaCriancasFragment, secListaCriancasFragment.getTag()).commit();
            }



        });


        return root;
    }

    protected void onCreate(LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sec_dados_criancas, container, false);

        ld = view.findViewById(R.id.listdados);

        return;

    }

    public void pedidoDosDadosDaCrianca(View v) {
        //iniciar o meu pedido à API

    }


    public void updateUI() {
        //lista onde irá ficar armazenado a string para mostrar na lista (listView)
        final ArrayList<String> dadosList = new ArrayList<>();


        //ciclo que percorre todos as crianças retornados pela API
        for (int i = 0; i < _api._listaCriancas.size(); i++) {
            //variável que guarda os dados da criança (no formato key-value-pair)
            HashMap<String, String> crianca = _api._listaCriancas.get(i);


            //string com os dados a mostrar na lista no formato - nome
            String nome_crianca = "Nome:\n" + crianca.get("nome_crianca") + "\n\nIdade:\n" + crianca.get("idade") +
                    "\n\nSala:\n" + crianca.get("sala") + "\n\nAlergias:\n" + crianca.get("alergias") +
                    "\n\nRestrições Alimentares:\n" + crianca.get("restricao") + "\n\nDoenças:\n" + crianca.get("doenca_cronica")
                    + "\n\nContacto:\n" + crianca.get("contacto");
            //aluno.get("nome")+" ("+aluno.get("id")+") \n"+aluno.get("email");
            dadosList.add(nome_crianca);


        }
        ld.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dadosList));


    }




}
