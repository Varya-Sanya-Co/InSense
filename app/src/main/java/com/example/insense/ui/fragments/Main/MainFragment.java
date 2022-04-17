package com.example.insense.ui.fragments.Main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentMainBinding;
import com.example.insense.ui.fragments.Main.Clocks.ClockFaceFragment;


public class MainFragment extends Fragment {

    private FragmentMainBinding fragmentMainBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.clock_fragment, new ClockFaceFragment());
        ft.commit();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        fragmentMainBinding.buttonAboutAction.setOnClickListener(v -> {
            if(App.getInstance().getGlobalTimer().getIsTimer()==false){ App.getInstance().getGlobalTimer().setTimer(true);}else
            { App.getInstance().getGlobalTimer().setTimer(false);} });

        fragmentMainBinding.buttonMainProfile.setOnClickListener(v -> NavHostFragment.findNavController(
                MainFragment.this).navigate(R.id.action_mainFragment_to_profileFragment));

        fragmentMainBinding.buttonMainCalendar.setOnClickListener(v -> NavHostFragment.findNavController(
                MainFragment.this).navigate(R.id.action_mainFragment_to_calendarFragment));

        fragmentMainBinding.buttonMainCategories.setOnClickListener(v -> NavHostFragment.findNavController(
                MainFragment.this).navigate(R.id.action_mainFragment_to_categoriesFragment ));

        return fragmentMainBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      }
}