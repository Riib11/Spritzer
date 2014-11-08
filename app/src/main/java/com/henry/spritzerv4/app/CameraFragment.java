package com.henry.spritzerv4.app;

import com.henry.spritzerv4.app.ResultsActivity;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

import com.henry.spritzerv4.app.MainActivity;

import static com.henry.spritzerv4.app.MainActivity.getOutputMediaFileUri;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CameraFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CameraFragment extends Fragment {

    //ABBEYY:
    public static final int TAKE_PICTURE = 0;
    public static final int SELECT_FILE = 1;

    //private String resultUrl = "result.txt";

    // For Checking what instance, but –
    //          I should change this because this is an only Picture Taking Instance.
//    private final int TAKE_PICTURE = 0;
//    private final int SELECT_FILE = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CameraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CameraFragment newInstance(String param1, String param2) {
        CameraFragment fragment = new CameraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public CameraFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false);

        //captureImageFromCamera();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


/////////////////////////////////////////////////

//    public void captureImageFromCamera( View view) {
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        Uri fileUri = getOutputMediaFileUri(); // create a file to save the image
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
//
//        startActivityForResult(intent, TAKE_PICTURE);
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode != Activity.RESULT_OK)
//            return;
//
//        String imageFilePath = null;
//
//        switch (requestCode) {
//            case TAKE_PICTURE:
//                imageFilePath = getOutputMediaFileUri().getPath();
//                break;
//            case SELECT_FILE: {
//                Uri imageUri = data.getData();
//
//                String[] projection = {MediaStore.Images.Media.DATA};
//                Cursor cur = getActivity().managedQuery(imageUri, projection, null, null, null);
//                cur.moveToFirst();
//                imageFilePath = cur.getString(cur.getColumnIndex(MediaStore.Images.Media.DATA));
//            }
//            break;
//        }
//
//        //Remove output file
//        getActivity().deleteFile(resultUrl);
//
//        Intent results = new Intent(getActivity(), ResultsActivity.class);
//        results.putExtra("IMAGE_PATH", imageFilePath);
//        results.putExtra("RESULT_PATH", resultUrl);
//        startActivity(results);
//    }

}
