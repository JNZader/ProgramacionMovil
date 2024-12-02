package com.example.appchat.view;
import com.example.appchat.R;
import com.example.appchat.adapters.ImageAdapter;
import com.example.appchat.databinding.ActivityPostBinding;
import com.example.appchat.util.ImageUtils;

import com.example.appchat.viewmodel.PostViewModel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.appchat.model.Post;
import com.example.appchat.util.Validaciones;
import java.util.ArrayList;
import java.util.List;

public class PostActivity {}