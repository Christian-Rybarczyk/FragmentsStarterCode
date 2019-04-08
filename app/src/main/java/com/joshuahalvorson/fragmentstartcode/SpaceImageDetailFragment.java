package com.joshuahalvorson.fragmentstartcode;


import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpaceImageDetailFragment extends Fragment {

    private ImageView spaceImageView;

    public SpaceImageDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_space_image_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        final SpaceImageListItem spaceImageListItem = (SpaceImageListItem) getArguments().getSerializable(MainActivity.SPACE_IMAGE_KEY);
        spaceImageView = view.findViewById(R.id.space_image_view);

        if(spaceImageListItem != null){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final SpaceImageDetails spaceImageDetails = SpaceImageRepository.getSpaceImageDetails(spaceImageListItem.getId());
                    new DownloadImageTask().execute(spaceImageDetails.getImageFiles().get(0).getFileUrl());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView)view.findViewById(R.id.space_image_title)).setText(spaceImageDetails.getName());
                            ((TextView)view.findViewById(R.id.space_image_desc)).setText(spaceImageDetails.getDescription());
                        }
                    });
                }
            }).start();
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = SpaceImageRepository.getSpaceImageBitmap(strings[0]);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            spaceImageView.setImageBitmap(bitmap);
        }
    }
}
