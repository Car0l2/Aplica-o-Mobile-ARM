package pt.ismt.arm.ui.secaddcriancas;

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

public class SecaddCriancasFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sec_add_criancas, container, false);


        return root;
    }
}
