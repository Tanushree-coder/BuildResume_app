package com.example.buildresume.PDF;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buildresume.MainActivity;
import com.example.buildresume.PDFActivity;
import com.example.buildresume.R;
import com.example.buildresume.home.HomeFragment;

public class PDFFragment extends Fragment {


    public static final String TAG = "TAGPDFFragment";
    private EditText myEditText;
    Button button;
    Button exitbtn;

    public PDFFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);


        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setExitTransition(inflater.inflateTransition(R.transition.fade));

        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setEnterTransition(inflater1.inflateTransition(R.transition.slide_right));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p_d_f, container, false);
        button=view.findViewById(R.id.pdfcreator);
        exitbtn=view.findViewById(R.id.exit);
        Log.i(TAG, "onCreateView: ");
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                makepdf();
            }

            private void makepdf() {
                Intent i = new Intent(getActivity(), PDFActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
            private void home(){
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);

            }
        });

        return view;
    }



    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "onViewStateRestored: ");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

}