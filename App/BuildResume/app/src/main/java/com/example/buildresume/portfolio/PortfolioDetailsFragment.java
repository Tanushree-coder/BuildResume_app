package com.example.buildresume.portfolio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.buildresume.R;
import com.example.buildresume.SharedPrefManager.SharedPrefManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class PortfolioDetailsFragment extends BottomSheetDialogFragment {


    private static final String TAG = "TAGPortfolioDetails";
    private static final int PICK_IMAGE = 101;
    private ImageView imgPortfolio;
    private TextView title,description;
    private SharedPrefManager sharedPrefManager;


    public PortfolioDetailsFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");


        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setExitTransition(inflater.inflateTransition(R.transition.fade));

        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setEnterTransition(inflater1.inflateTransition(R.transition.slide_right));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i(TAG, "onViewCreated: ");
        imgPortfolio = view.findViewById(R.id.portfolio_details_img);
        title = view.findViewById(R.id.portfolio_details_title);
        description = view.findViewById(R.id.portfolio_details_desc);


        sharedPrefManager = new SharedPrefManager(getActivity());

        title.setText(sharedPrefManager.getProjects());


        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setProjects(title.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        description.setText(sharedPrefManager.getProjects());


        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setProjects(description.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        Bundle bundle = getArguments();
        PortfolioItem item = (PortfolioItem) bundle.getSerializable("object");

        imgPortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


            }
        });

        loadPortfolioData(item);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if(resultCode== Activity.RESULT_OK && requestCode==PICK_IMAGE){
            imgPortfolio.setImageURI(data.getData());

        }
    }

    void loadPortfolioData(PortfolioItem item) {

        Glide.with(getContext()).load(item.getImage()).into(imgPortfolio);



    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
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
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }
}