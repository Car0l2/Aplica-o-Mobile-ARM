package pt.ismt.arm.ui.seclistacriancas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import pt.ismt.arm.R;
import pt.ismt.arm.ui.secaddcriancas.SecaddCriancasFragment;
import pt.ismt.arm.ui.secaddfuncionario.SecAddFuncionarioFragment;
import pt.ismt.arm.ui.secdadoscriancas.SecDadosCriancasFragment;
import pt.ismt.arm.ui.secdadosfuncionarios.SecDadosFuncionariosFragment;

public class SecListaCriancasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_lista_criancas, container, false);

        Button listcriadd = (Button) root.findViewById(R.id.listcriadd);
        listcriadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecaddCriancasFragment secaddCriancasFragment = new SecaddCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secaddCriancasFragment, secaddCriancasFragment.getTag()).commit();

            }
        });
        Button dadoscri = (Button) root.findViewById(R.id.dadoscri);
        dadoscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecDadosCriancasFragment secDadosCriancasFragment = new SecDadosCriancasFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secDadosCriancasFragment, secDadosCriancasFragment.getTag()).commit();

            }
        });


        return root;
    }
}
