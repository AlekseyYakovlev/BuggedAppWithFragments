package ru.spb.yakovlev.hellofragment;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class ContentFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content1, container, false);

        Button updateButton = view.findViewById(R.id.updateButton);
        Button switchButton = view.findViewById(R.id.switchButton);

        final TextView updateBox = view.findViewById(R.id.textBox);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curDate = new Date().toString();
                updateBox.setText(curDate);
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentFragment detailFragment = new ContentFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.firstFragment, detailFragment);
                transaction.commit();
            }
        });


        return view;
    }
}
