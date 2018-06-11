package com.example.abhijeetsingh.bizopt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static android.app.Activity.RESULT_OK;

public class ThirdFragment extends Fragment {
    private Button Record_button;
    private VideoView vView;
    static final int REQUEST_VIDEO_CAPTURE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_third, container, false);

        Record_button=(Button)v.findViewById(R.id.record_button);
        vView=(VideoView)v.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(v.getContext());
        mediaController.setAnchorView(vView);
// set media controller object for a video view
        vView.setMediaController(mediaController);
        Record_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakeVideoIntent();


            }
        });
        return  v;



    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
            onActivityResult(REQUEST_VIDEO_CAPTURE,RESULT_OK,takeVideoIntent);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            vView.setVideoURI(videoUri);
            vView.start();
        }
    }
}
