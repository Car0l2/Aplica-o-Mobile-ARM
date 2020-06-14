package pt.ismt.arm.ui.secdadoscriancas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pt.ismt.arm.R;
import pt.ismt.arm.ui.secactcrianca.SecActCriancaFragment;

public class SecDadosCriancasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_dados_criancas, container, false);
        Button listcriact = (Button) root.findViewById(R.id.listfunadd);
        listcriact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                SecActCriancaFragment secActCriancaFragment = new SecActCriancaFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment_sec, secActCriancaFragment, secActCriancaFragment.getTag()).commit();

            }
        });


        return root;
    }
}
