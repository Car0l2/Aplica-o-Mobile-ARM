package pt.ismt.arm.ui.dadoscriancas;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;

import pt.ismt.arm.ApiConnection;
import pt.ismt.arm.R;
import pt.ismt.arm.ui.medregisto.MedRegistoFragment;

public class DadosCriancasFragment extends Fragment {

    ListView ld ;
    ApiConnection _api;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dados_criancas, container, false);

        ld = root.findViewById(R.id.listdados);

        _api= new ApiConnection();
        _api._activity = DadosCriancasFragment.this;
        _api._listaCriancas =new ArrayList();
        _api.execute("http://10.0.2.2:3001/api/v1/crianca/2","0");

        Button addregmed = (Button) root.findViewById(R.id.addregmed);
        addregmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                MedRegistoFragment medRegistoFragment = new MedRegistoFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, medRegistoFragment, medRegistoFragment.getTag()).commit();

            }
        });


        return root;
    }

    protected void onCreate(LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_dados_criancas, container, false);

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
        for (int i=0; i<_api._listaCriancas.size(); i++) {
            //variável que guarda os dados da criança (no formato key-value-pair)
            HashMap<String, String> crianca = _api._listaCriancas.get(i);


            //string com os dados a mostrar na lista no formato - nome
            String nome_crianca ="Nome:\n"+crianca.get("nome_crianca")+"\n\nIdade:\n"+crianca.get("idade")+
                    "\n\nSala:\n"+crianca.get("sala")+"\n\nAlergias:\n"+crianca.get("alergias")+
                    "\n\nRestrições Alimentares:\n"+crianca.get("restricao")+"\n\nDoenças:\n"+crianca.get("doenca_cronica")
                    +"\n\nContacto:\n"+crianca.get("contacto");
            //aluno.get("nome")+" ("+aluno.get("id")+") \n"+aluno.get("email");
            dadosList.add(nome_crianca);


        }
       /* ListAdapter adapter = new SimpleAdapter(requireContext(), dadosLista, R.layout.fragment_listacriancas,
                new String[]{"id_cliente", "nome", "nome_perfil", "morada", "contribuinte", "contacto"},
                new int[]{R.id.listcri, R.id.listcri});
        lv.setAdapter(adapter);
     */   ld.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dadosList));

        /*public void run() {
            recyclerViewCursos.setLayoutManager(new LinearLayoutManager(getContext()));
            PlanosCursoAdapter planosCursoAdapter = new PlanosCursoAdapter (getContext(), getTargetFragment());
            recyclerViewCursos.setAdapter(planosCursoAdapter);
            planosCursoAdapter.refreshList(planosList);

        }*/
        //string com os dados a mostrar na lista no formato - nome(id) e por baixo o email
       /* String nome_e_id = aluno.get("nome")+" ("+aluno.get("id")+") \n"+aluno.get("email");
        dadosLista.add(nome_e_id);
    }
        _lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, dadosLista));

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dadosLista);
        _lv.setAdapter(adapter);*/
    }
};
