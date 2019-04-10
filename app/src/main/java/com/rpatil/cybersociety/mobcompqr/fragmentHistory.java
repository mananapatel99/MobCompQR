package com.rpatil.cybersociety.mobcompqr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


public class fragmentHistory extends Fragment {

    private static final String TAG = "fragmentHistory";

    private Button sHistory;
    private Button gHistory;

    private OnFragmentInteractionListener mListener;


    private TextView ts;
    private TextView pl;

    public fragmentHistory() {
        // Required empty public constructor
    }

    public static fragmentHistory newInstance() {
        fragmentHistory fragmentHistory = new fragmentHistory();
        Bundle args = new Bundle();
        fragmentHistory.setArguments(args);
        return fragmentHistory;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sHistory = view.findViewById(R.id.scn_his_btn);
        gHistory = view.findViewById(R.id.gen_his_btn);

        sHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i  = new Intent(getContext(), fragmentScanHistory.class);
                    startActivity(i);
            }
        });

        gHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(getContext(), fragmentGenerateHistory.class);
                startActivity(i);
            }
        });
    }



    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);

    }
}
