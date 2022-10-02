package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    public void showDetails(String name){
        TextView textView = (TextView) getView().findViewById(R.id.text1);
        textView.setText(name);

        ImageView imageView = (ImageView) getView().findViewById(R.id.imageView1);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        switch (name){
            case "Amsterdam":
                imageView.setImageResource(R.drawable.amsterdam);
                break;
            case "Brussels":
                imageView.setImageResource(R.drawable.brussels);
                break;
            case "Japan":
                imageView.setImageResource(R.drawable.japan);
                break;
        }
    }
}