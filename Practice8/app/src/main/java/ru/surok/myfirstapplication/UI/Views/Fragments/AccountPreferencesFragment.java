package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.surok.myfirstapplication.UI.VIewModels.AccountViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentAccountPreferencesBinding;

public class AccountPreferencesFragment extends Fragment {

    private AccountViewModel model;

    public AccountPreferencesFragment() {
        super(R.layout.fragment_account_preferences);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAccountPreferencesBinding binding = FragmentAccountPreferencesBinding
                .inflate(inflater, container, false);

        model = new ViewModelProvider(this).get(AccountViewModel.class);

        binding.switchTheme.setChecked(model.getPref(getString(R.string.theme_preference_key)));
        binding.switch2.setChecked(model.getPref(getString(R.string.switch2_key)));
        binding.switch3.setChecked(model.getPref(getString(R.string.switch3_key)));

        binding.switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                model.savePref(getString(R.string.theme_preference_key), b);
            }
        });

        binding.switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                model.savePref(getString(R.string.switch2_key), b);
            }
        });

        binding.switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                model.savePref(getString(R.string.switch3_key), b);
            }
        });
        return binding.getRoot();
    }
}
