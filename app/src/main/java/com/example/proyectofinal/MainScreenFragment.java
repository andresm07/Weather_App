package com.example.proyectofinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainScreenFragment extends Fragment {
    private RecyclerView cityRecyclerView;
    private CityAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.adapter = new CityAdapter();
        View view = inflater.inflate(R.layout.fragment_mainscreen, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.cityRecyclerView = view.findViewById(R.id.cityRecyclerView);
        this.cityRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.adapter.setCityList(getCities());
        this.cityRecyclerView.setAdapter(this.adapter);
    }

    private ArrayList<City> getCities() {
        ArrayList<City> result = new ArrayList<>();
        result.add(new City("San Jose", "Costa Rica"));
        result.add(new City("Heredia", "Costa Rica"));
        return result;
    }
}