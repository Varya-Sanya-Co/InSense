package com.example.insense.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.insense.R;
import com.example.insense.ui.authentication.authentication.Login.LoginViewModel;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    LoginViewModel viewModel = new LoginViewModel();
    private NavController navController;
    private Set topLevelDestinations;
    private NavController.OnDestinationChangedListener destinationListener;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationContext();
        navController = getRootNavController();
        Log.i("NAV","navController found");
        prepareRootNavController(navController);
    }

    private NavController getRootNavController() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        return navHostFragment.getNavController();
    }

    private void prepareRootNavController(NavController navController) {
        NavGraph navGraph = navController.getNavInflater().inflate(getMainNavigationGraphId());
        viewModel.authenticationState.observe(this,
                authenticationState -> {
                    if (authenticationState == LoginViewModel.AuthenticationState.AUTHENTICATED) {
                        navGraph.setStartDestination(getTabsDestination());
                    } else {
                        navGraph.setStartDestination(getSignInDestination());
                    }
                    navController.setGraph(navGraph);
                });
    }

    private int getMainNavigationGraphId() {
        return R.navigation.main_graph;
    }

    private int getTabsDestination() {
        return R.id.tabsFragment;
    }

    private int getSignInDestination() {
        return R.id.authenticationFragment;
    }
}