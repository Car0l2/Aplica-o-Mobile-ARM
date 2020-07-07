package pt.ismt.arm.ui.seclistacriancas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.HashMap;

import pt.ismt.arm.ApiConnection;
import pt.ismt.arm.R;
import pt.ismt.arm.ui.dadoscriancas.DadosCriancasFragment;
import pt.ismt.arm.ui.secaddcriancas.SecaddCriancasFragment;
import pt.ismt.arm.ui.secaddfuncionario.SecAddFuncionarioFragment;
import pt.ismt.arm.ui.secdadoscriancas.SecDadosCriancasFragment;
import pt.ismt.arm.ui.secdadosfuncionarios.SecDadosFuncionariosFragment;

public class SecListaCriancasFragment extends Fragment {

    ListView lv;
    ApiConnection _api;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_lista_criancas, container, false);

        lv = root.findViewById(R.id.listacri);

        _api = new ApiConnection();
        _api._activity = SecListaCriancasFragment.this;
        _api._listaCriancas = new ArrayList();
        _api.execute("http://10.0.2.2:3001/api/v1/criancas", "0");

        Button listcriadd = (Button) root.findViewById(R.id.listcriadd);
        listcriadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecaddCriancasFragment secaddCriancasFragment = new SecaddCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secaddCriancasFragment, secaddCriancasFragment.getTag()).commit();

            }
        });


        return root;
    }

    protected void onCreate(LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sec_lista_criancas, container, false);

        lv = view.findViewById(R.id.listacri);

        return;

    }

    public void pedidoDosDadosDaCrianca(View v) {
        //iniciar o meu pedido à API

    }


    public void updateUI() {
        //lista onde irá ficar armazenado a string para mostrar na lista (listView)
        final ArrayList<String> dadosLista = new ArrayList<>();


        //ciclo que percorre todos as crianças retornados pela API
        for (int i = 0; i < _api._listaCriancas.size(); i++) {
            //variável que guarda os dados da criança (no formato key-value-pair)
            HashMap<String, String> crianca = _api._listaCriancas.get(i);
            lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    SecDadosCriancasFragment secDadosCriancasFragment = new SecDadosCriancasFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secDadosCriancasFragment, secDadosCriancasFragment.getTag()).commit();


                }
            });

            //string com os dados a mostrar na lista no formato - nome
            String nome_crianca = crianca.get("nome_crianca");
            dadosLista.add(nome_crianca);

        }

        lv.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, dadosLista));
    }
}