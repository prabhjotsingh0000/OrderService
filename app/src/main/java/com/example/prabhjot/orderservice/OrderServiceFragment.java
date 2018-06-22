package com.example.prabhjot.orderservice;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderServiceFragment extends Fragment {

    ArrayList<OrderServiceModel> al = new ArrayList<>();
    RecyclerView rv;
    View inflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.os_fragment_layout, container, false);
        rv = (RecyclerView) inflate.findViewById(R.id.recycler_view);

        al.add(new OrderServiceModel("ALBUMIN, CSF, Laboratory",false));
        al.add(new OrderServiceModel("ALBUMIN, CSF, Laboratory",false));
        al.add(new OrderServiceModel("ALBUMIN, CSF, Laboratory",false));
        al.add(new OrderServiceModel("ALBUMIN, CSF, Laboratory",false));
        al.add(new OrderServiceModel("ALBUMIN, CSF, Laboratory",false));

        OrderServiceAdapter mAdapter = new OrderServiceAdapter(al, getActivity(),this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(mAdapter);

        TextView textView= (TextView) inflate.findViewById(R.id.number_of_services);
        String numberOfServices= "" + al.size();
        textView.setText(numberOfServices);
        return inflate;
    }


    public void updateCount()
    {
        TextView textView= (TextView) inflate.findViewById(R.id.number_of_services);
        String numberOfServices= "" + al.size();
        textView.setText(numberOfServices);
    }

}
