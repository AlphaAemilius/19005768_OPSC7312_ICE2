package com.vc19005768.sqllitetodo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.vc19005768.sqllitetodo.ChoreModel;
import com.vc19005768.sqllitetodo.Database.DatabaseHandler;
import com.vc19005768.sqllitetodo.R;

public class AddChoreFragment extends Fragment {

    Button lbtnSaveChore;
    EditText ledtChoreID, ledtChoreName, ledtChoreTime;
    private View view;

    private DatabaseHandler Choredb;
    public AddChoreFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AddChoreFragment newInstance(String param1, String param2) {
        AddChoreFragment fragment = new AddChoreFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    private void assignComponents() {
        ledtChoreID = view.findViewById(R.id.edtChoreID);
        ledtChoreName = view.findViewById(R.id.edtChoreName);
        ledtChoreTime = view.findViewById(R.id.edtChoreTime);
        lbtnSaveChore = view.findViewById(R.id.btnSaveChore);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_chore, container, false);
        assignComponents();

        Choredb = new DatabaseHandler(getActivity()); //gets instance of DB

        lbtnSaveChore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeChore(); //calls method to write to db
                clearFields();
            }


        });

        return view;
    }

    private void clearFields() {
        ledtChoreName.setText("");
        ledtChoreTime.setText("");
        ledtChoreID.setText("");
    }


    private void storeChore() { //passes values to the write to DB method in DatabaseHandler
        Choredb.WriteToDb(new ChoreModel(
                Integer.parseInt(ledtChoreID.getText().toString()),
                ledtChoreName.getText().toString(),
                ledtChoreTime.getText().toString()));

    }
}