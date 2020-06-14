package pt.ismt.arm.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pt.ismt.arm.R;
import pt.ismt.arm.ui.ajuda.AjudaFragment;
import pt.ismt.arm.ui.dadospessoais.DadosPessoaisFragment;
import pt.ismt.arm.ui.listacriancas.ListaCriancasFragment;
import pt.ismt.arm.ui.medregisto.MedRegistoFragment;
import pt.ismt.arm.ui.sobre.SobreFragment;

public class InicioFragment extends Fragment {

    public InicioFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_inicio,container, false);
        Button btn_dados = (Button) root.findViewById(R.id.btn_dados);
        btn_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                DadosPessoaisFragment dadosPessoaisFragment = new DadosPessoaisFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, dadosPessoaisFragment, dadosPessoaisFragment.getTag()).commit();

            }
              });
        Button btn_listcri = (Button) root.findViewById(R.id.btn_listcri);
        btn_listcri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                ListaCriancasFragment listaCriancasFragment = new ListaCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, listaCriancasFragment, listaCriancasFragment.getTag()).commit();

            }
        });
        Button btn_addmedreg = (Button) root.findViewById(R.id.btn_addmedreg);
        btn_addmedreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                MedRegistoFragment medRegistoFragment = new MedRegistoFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, medRegistoFragment, medRegistoFragment.getTag()).commit();

            }
        });
        Button btn_sobre = (Button) root.findViewById(R.id.btn_sobre);
        btn_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SobreFragment sobreFragment = new SobreFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, sobreFragment, sobreFragment.getTag()).commit();

            }
        });
        Button btn_ajuda = (Button) root.findViewById(R.id.btn_ajuda);
        btn_ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                AjudaFragment ajudaFragment = new AjudaFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, ajudaFragment, ajudaFragment.getTag()).commit();

            }
        });

        return root;




}
}
