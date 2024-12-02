package com.example.appchat.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appchat.R;
import com.example.appchat.adapters.PostAdapter;
import com.example.appchat.databinding.FragmentHomeBinding;
import com.example.appchat.providers.AuthProvider;
import com.example.appchat.view.MainActivity;
import com.example.appchat.view.PostActivity;
import com.example.appchat.viewmodel.PostViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private AuthProvider authProvider;
    public HomeFragment() {
        // Constructor vacío requerido
    }


}


