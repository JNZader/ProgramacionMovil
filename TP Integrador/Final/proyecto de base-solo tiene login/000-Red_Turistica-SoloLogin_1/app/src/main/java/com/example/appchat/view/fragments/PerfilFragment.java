package com.example.appchat.view.fragments;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.appchat.R;
import com.example.appchat.databinding.FragmentPerfilBinding;
import com.example.appchat.util.ImageUtils;
import com.squareup.picasso.Picasso;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;
import java.io.IOException;

public class PerfilFragment extends Fragment {
    private FragmentPerfilBinding binding;
    private ActivityResultLauncher<Intent> galleryLauncher;

    public PerfilFragment() {
        // Constructor vacío
    }

}