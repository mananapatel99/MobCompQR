package com.rpatil.cybersociety.mobcompqr.scanhistory;


import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import android.support.v4.widget.SwipeRefreshLayout;

import android.widget.Toast;
import android.os.Handler;


import android.view.ViewGroup;

import com.rpatil.cybersociety.mobcompqr.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentScanHistory#newInstance} factory method to
 * create an instance of this fragment.
 */


public class fragmentScanHistory extends Fragment {

    private static final String TAG = "fragmentScanHistory";
    private RecyclerView recyclerView;

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    // @BindView(R.id.swipe_refresh_recycler_list)
    // SwipeRefreshLayout swipeRefreshRecyclerList;

    private SwipeRefreshLayout swipeRefreshRecyclerList;
    private ScanHistoryAdapter mAdapter;

    private ArrayList<ScanHistoryModel> modelList = new ArrayList<>();

    public fragmentScanHistory() {
        // Required empty public constructor
    }

    public static fragmentScanHistory newInstance(String param1, String param2) {
        fragmentScanHistory fragment = new fragmentScanHistory();
        return fragment;
    }

    public static fragmentScanHistory newInstance() {
        fragmentScanHistory fragment = new fragmentScanHistory();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan_history, container, false);

        // ButterKnife.bind(this);
        findViews(view);

        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapter();

        swipeRefreshRecyclerList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Do your stuff on refresh
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (swipeRefreshRecyclerList.isRefreshing())
                            swipeRefreshRecyclerList.setRefreshing(false);
                    }
                }, 5000);

            }
        });


    }


    private void findViews(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        swipeRefreshRecyclerList = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_recycler_list);
    }


    private void setAdapter() {


        modelList.add(new ScanHistoryModel("Android", "Hello " + " Android"));


        mAdapter = new ScanHistoryAdapter(getActivity(), modelList);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(mAdapter);


        mAdapter.SetOnItemClickListener(new ScanHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, ScanHistoryModel model) {

                //handle item click events here
                Toast.makeText(getActivity(), "Hey " + model.getTitle(), Toast.LENGTH_SHORT).show();


            }
        });


    }

}
