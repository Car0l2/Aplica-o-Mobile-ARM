package pt.ismt.arm.ui.secdadosfuncionarios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pt.ismt.arm.R;
import pt.ismt.arm.ui.dadospessoais.DadosPessoaisFragment;
import pt.ismt.arm.ui.secactfuncionarios.SecActFuncionariosFragment;
import pt.ismt.arm.ui.secaddfuncionario.SecAddFuncionarioFragment;

public class SecDadosFuncionariosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_dados_funcionarios, container, false);
        Button listfunact = (Button) root.findViewById(R.id.listfunadd);
        listfunact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecActFuncionariosFragment secActFuncionariosFragment = new SecActFuncionariosFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secActFuncionariosFragment, secActFuncionariosFragment.getTag()).commit();

            }
        });


        return root;
    }
}
