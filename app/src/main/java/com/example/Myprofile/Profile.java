package com.example.Myprofile;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentProfileBinding;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment implements View.OnClickListener  {
FragmentProfileBinding binding;

    private DatePickerDialog datePickerDialog;

SafeVarargs varar;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types o f   parameters
    private String mParam1;
    private String mParam2;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
binding=FragmentProfileBinding.inflate(inflater);
        return binding.getRoot() ;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
int number=ProfileArgs.fromBundle(getArguments()).getNum();
Log.d("Safe args value","is "+number+" .");
        binding.shape4.setOnClickListener(this);

        binding.CancelButton.setOnClickListener(this);
        binding.SaveButton.setOnClickListener(this);
        binding.e4.setOnClickListener(this);
    }

    @SuppressLint("SuspiciousIndentation")
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.shape4) {
                binding.e1.setEnabled(true);
                binding.e2.setEnabled(true);
                binding.e3.setEnabled(true);
                binding.e4.setEnabled(true);
                binding.e5.setEnabled(true);
                binding.e6.setEnabled(true);
                binding.e7.setEnabled(true);
                binding.SaveButton.setVisibility(View.VISIBLE);
                binding.CancelButton.setVisibility(View.VISIBLE);
                binding.SaveButton.setEnabled(true);
                binding.CancelButton.setEnabled(true);
            }
            if (view.getId() == R.id.SaveButton) {
                //Make copy of data to check if data Changed to send request or not
                //Send request To post New Data .

            }
            if (view.getId() == R.id.CancelButton) {

                //Reset Data  and close editing.
                binding.e1.setEnabled(false);
                binding.e2.setEnabled(false);
                binding.e3.setEnabled(false);
                binding.e4.setEnabled(false);
                binding.e5.setEnabled(false);
                binding.e6.setEnabled(false);
                binding.e7.setEnabled(false);
                binding.SaveButton.setVisibility(View.INVISIBLE);
                binding.CancelButton.setVisibility(View.INVISIBLE);
                binding.SaveButton.setEnabled(false);
                binding.CancelButton.setEnabled(false);
                Toast.makeText(requireContext(), "Editing finshed", Toast.LENGTH_LONG).show();
            }
            if (view.getId() == R.id.e4 ||view.getId() == R.id.img3) {

                // binding.e4.setText();


                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
//DatePickerDialog datePickerDialog1=new DatePickerDialog(this);
                int style = AlertDialog.THEME_HOLO_LIGHT;
                // on below line we are creating a variable for date picker dialog.
                datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        requireContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                binding.e4.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year - 21, month, day);
                Log.e("date", System.currentTimeMillis() + "");
                Calendar c1 = Calendar.getInstance();

                c1.set(year - 20, 0, 1);
                datePickerDialog.getDatePicker().setMaxDate((c1.getTimeInMillis()));
                c1.set(year-75,0,1);
                datePickerDialog.getDatePicker().setMinDate((c1.getTimeInMillis()));

                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }

        }




}