package com.example.prac11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        String editstring1 = ThirdFragmentArgs.fromBundle(getArguments()).getStringFromFirst();
        String editstring2 = ThirdFragmentArgs.fromBundle(getArguments()).getStringFromSecond();
        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);
        EditText editText1 = view.findViewById(R.id.editText1);
        if(editstring1 != null) {
            editText1.setHint(editstring1);
        }
        EditText editText2 = view.findViewById(R.id.editText2);
        if(editstring2 != null) {
            editText2.setHint(editstring2);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText1.getText().toString();
                ThirdFragmentDirections.ActionThirdFragmentToFirstFragment action = ThirdFragmentDirections.actionThirdFragmentToFirstFragment();
                action.setStringFromThird(text);
                Navigation.findNavController(view).navigate(action);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText2.getText().toString();
                ThirdFragmentDirections.ActionThirdFragmentToSecondFragment action = ThirdFragmentDirections.actionThirdFragmentToSecondFragment();
                action.setStringFromThird(text);
                Navigation.findNavController(view).navigate(action);
            }
        });
        return view;
    }
}