package com.ghiyats.fish.temannelayan.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Range;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ghiyats.fish.temannelayan.Helper.RangerDbHelper;
import com.ghiyats.fish.temannelayan.Helper.SessionManager;
import com.ghiyats.fish.temannelayan.Model.RangerModel;
import com.ghiyats.fish.temannelayan.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RangerFragment extends Fragment {
    SessionManager sessionManager;
    RangerDbHelper rangerHelper;
    @InjectView(R.id.rangerList) ListView rangerList;
    ArrayList<RangerModel> rangers;


    public RangerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ranger, container, false);
        ButterKnife.inject(getActivity());

        sessionManager = new SessionManager(getActivity());
        rangerHelper = new RangerDbHelper(getActivity());
        rangers = new ArrayList<RangerModel>();
        rangers = rangerHelper.load();



        return view;
    }


}
