package com.rpatil.cybersociety.mobcompqr.genhistory;


import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import android.support.v4.widget.SwipeRefreshLayout;

import android.widget.Toast;
import android.os.Handler;


import android.view.ViewGroup;

import com.rpatil.cybersociety.mobcompqr.GridMarginDecoration;
import com.rpatil.cybersociety.mobcompqr.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentGenHistory#newInstance} factory method to
 * create an instance of this fragment.
 */


public class fragmentGenHistory extends Fragment {

    private static final String TAG = "fragmentGenHistory";
    private RecyclerView recyclerView;

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    // @BindView(R.id.swipe_refresh_recycler_list)
    // SwipeRefreshLayout swipeRefreshRecyclerList;

    private SwipeRefreshLayout swipeRefreshRecyclerList;
    private GenHistoryAdapter mAdapter;

    private ArrayList<GenHistoryModel> modelList = new ArrayList<>();

    public fragmentGenHistory() {
        // Required empty public constructor
    }

    public static fragmentGenHistory newInstance(String param1, String param2) {
        fragmentGenHistory fragment = new fragmentGenHistory();
        return fragment;
    }

    public static fragmentGenHistory newInstance() {
        fragmentGenHistory fragment = new fragmentGenHistory();
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

        View view = inflater.inflate(R.layout.fragment_gen_history, container, false);

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


        modelList.add(new GenHistoryModel("Android", "Hello " + " Android"));


        mAdapter = new GenHistoryAdapter(getActivity(), modelList);

        recyclerView.setHasFixedSize(true);


        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.addItemDecoration(new GridMarginDecoration(getActivity(), 2, 2, 2, 2));
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(mAdapter);


        mAdapter.SetOnItemClickListener(new GenHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GenHistoryModel model) {

                //handle item click events here
                Toast.makeText(getActivity(), "Hey " + model.getTitle(), Toast.LENGTH_SHORT).show();


            }
        });


    }

}
