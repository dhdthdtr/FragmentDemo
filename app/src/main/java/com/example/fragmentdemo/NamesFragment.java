package com.example.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NamesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final String[] names = {"Amsterdam", "Brussels" ,"Japan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, names);

        View view = inflater.inflate(R.layout.fragment_names, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.listView1);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (callback != null){
                    callback.onItemSelected(names[position]);
                }
            }
        });
        listView.setAdapter(adapter);
        return view;
    }

    public interface Callback{
        public void onItemSelected(String id);
    }

    private Callback callback;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if(activity instanceof Callback){
            callback = (Callback) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}