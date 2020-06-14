package pt.ismt.arm.ui.listacriancas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
import pt.ismt.arm.ui.secdadoscriancas.SecDadosCriancasFragment;

public class ListaCriancasFragment extends Fragment {

    ListView lv ;
    ApiConnection _api;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_listacriancas, container, false);


          //  _lv = _lv.findViewById(R.id.listcri);
          lv = root.findViewById(R.id.listcri);



        Button dadoscri = (Button) root.findViewById(R.id.button5);
        dadoscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                DadosCriancasFragment dadosCriancasFragment = new DadosCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, dadosCriancasFragment, dadosCriancasFragment.getTag()).commit();

            }
        });




        return root;
    }

    protected void onCreate(LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_listacriancas, container, false);

        lv = view.findViewById(R.id.listcri);

        return;

    }

    public void pedidoApiDeTodasCrianças(View v) {
        //iniciar o meu pedido à API
        _api= new ApiConnection();
        _api._activity = ListaCriancasFragment.this;
        _api._listaCriancas =new ArrayList();
        _api.execute("http://10.0.2.2:3001/api/v1/crianca/1","0");
    }


    public void updateUI() {
        //lista onde irá ficar armazenado a string para mostrar na lista (listView)
        final ArrayList<String> dadosLista = new ArrayList<>();

        //ciclo que percorre todos as crianças retornados pela API
        for (int i=0; i<_api._listaCriancas.size(); i++) {
            //variável que guarda os dados da criança (no formato key-value-pair)
            HashMap<String, String> crianca = _api._listaCriancas.get(i);

            //string com os dados a mostrar na lista no formato - nome
            String nome_crianca = crianca.get("nome_crianca");
            dadosLista.add(nome_crianca);
        }
       /* ListAdapter adapter = new SimpleAdapter(requireContext(), dadosLista, R.layout.fragment_listacriancas,
                new String[]{"id_cliente", "nome", "nome_perfil", "morada", "contribuinte", "contacto"},
                new int[]{R.id.listcri, R.id.listcri});
        lv.setAdapter(adapter);
     */   lv.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dadosLista));

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dadosLista);
        _lv.setAdapter(adapter);*/
    }
}
