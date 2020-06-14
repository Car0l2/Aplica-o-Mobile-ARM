package pt.ismt.arm.ui.seclistafuncionarios;

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
import pt.ismt.arm.ui.dadospessoais.DadosPessoaisFragment;
import pt.ismt.arm.ui.secaddfuncionario.SecAddFuncionarioFragment;
import pt.ismt.arm.ui.secdadosfuncionarios.SecDadosFuncionariosFragment;

public class SecListaFuncionariosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_lista_funcionarios, container, false);
        Button listfunadd = (Button) root.findViewById(R.id.listfunadd);
        listfunadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecAddFuncionarioFragment secAddFuncionarioFragment = new SecAddFuncionarioFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secAddFuncionarioFragment, secAddFuncionarioFragment.getTag()).commit();

            }
        });
        Button dadosfun = (Button) root.findViewById(R.id.dadosfun);
        dadosfun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecDadosFuncionariosFragment secDadosFuncionariosFragment = new SecDadosFuncionariosFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secDadosFuncionariosFragment, secDadosFuncionariosFragment.getTag()).commit();

            }
        });


        return root;
    }
}
