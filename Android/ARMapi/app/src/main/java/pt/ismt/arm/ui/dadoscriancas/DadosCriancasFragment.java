package pt.ismt.arm.ui.dadoscriancas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pt.ismt.arm.R;
import pt.ismt.arm.ui.medregisto.MedRegistoFragment;

public class DadosCriancasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dados_criancas, container, false);
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
}
