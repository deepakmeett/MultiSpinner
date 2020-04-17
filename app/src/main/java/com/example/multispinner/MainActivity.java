package com.example.multispinner;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    TextView textView;
    MultiSpinner multiSpinner;
    private String[] spinnerData = {"Android", "XML", "Java"};
    private ArrayList<String> multiSpinnerAnswer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        multiSpinner = findViewById( R.id.multi_spinner );
        textView = findViewById( R.id.text );
        
        try {
            LinkedHashMap<String, Boolean> list = new LinkedHashMap<>();
            for (int i = 0; i < spinnerData.length; i++) {
                final Boolean put = list.put( spinnerData[i], multiSpinnerAnswer.contains( spinnerData[i] ) );
            }
            final List<String> selectedOptions = new ArrayList<>();
            multiSpinner.setItems( list, new MultiSpinnerListener() {
                @Override
                public void onItemsSelected(boolean[] selected) {
                    selectedOptions.clear();
                    for (int i = 0; i < selected.length; i++) {
                        if (selected[i]) {
                            selectedOptions.add( spinnerData[i] );
                        }
                    }
                    textView.setText( android.text.TextUtils.join( ", ", selectedOptions ) );
                }
            } );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
