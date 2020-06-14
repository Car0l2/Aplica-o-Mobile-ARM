package pt.ismt.arm.ui.inicio_sec;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pt.ismt.arm.R;
import pt.ismt.arm.ui.dadospessoais.DadosPessoaisFragment;
import pt.ismt.arm.ui.secaddcriancas.SecaddCriancasFragment;
import pt.ismt.arm.ui.secaddfuncionario.SecAddFuncionarioFragment;
import pt.ismt.arm.ui.secajuda.SecAjudaFragment;
import pt.ismt.arm.ui.seclistacriancas.SecListaCriancasFragment;
import pt.ismt.arm.ui.seclistafuncionarios.SecListaFuncionariosFragment;
import pt.ismt.arm.ui.sobre.SobreFragment;

public class InicioSecFragment extends Fragment {

    public InicioSecFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_inicio,container, false);
        Button btn_listfun = (Button) root.findViewById(R.id.btn_listfun);
        btn_listfun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecListaFuncionariosFragment secListaFuncionariosFragment = new SecListaFuncionariosFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secListaFuncionariosFragment, secListaFuncionariosFragment.getTag()).commit();

            }


              });
        Button btn_listcri = (Button) root.findViewById(R.id.btn_listcri);
        btn_listcri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecListaCriancasFragment secListaCriancasFragment = new SecListaCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secListaCriancasFragment, secListaCriancasFragment.getTag()).commit();

            }
        });
        Button btn_addfun = (Button) root.findViewById(R.id.btn_addfun);
        btn_addfun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecAddFuncionarioFragment secAddFuncionarioFrgment = new SecAddFuncionarioFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secAddFuncionarioFrgment, secAddFuncionarioFrgment.getTag()).commit();

            }
        });
        Button btn_addcri = (Button) root.findViewById(R.id.btn_addcri);
        btn_addcri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecaddCriancasFragment secaddCriancasFragment = new SecaddCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secaddCriancasFragment, secaddCriancasFragment.getTag()).commit();

            }
        });
        Button btn_sobre = (Button) root.findViewById(R.id.btn_sobre);
        btn_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SobreFragment sobreFragment = new SobreFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, sobreFragment, sobreFragment.getTag()).commit();

            }
        });
        Button btn_ajuda = (Button) root.findViewById(R.id.btn_ajuda);
        btn_ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecAjudaFragment secAjudaFragment = new SecAjudaFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secAjudaFragment, secAjudaFragment.getTag()).commit();
            }
            });

        return root;




}
}
