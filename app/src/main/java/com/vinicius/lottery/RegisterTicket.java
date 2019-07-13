package com.vinicius.lottery;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.vinicius.lottery.com.vinicius.lottery.model.Ticket;
import com.vinicius.lottery.com.vinicius.lottery.model.Tuple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegisterTicket extends AppCompatActivity {

    final InputParser ip = new InputParser();
    final NumberHandler nh = new NumberHandler();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_ticket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button calculateButton = findViewById(R.id.calculate);
        Button addGameButton = findViewById(R.id.addGame);

        addGameButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = generateEditText();
                ((LinearLayout) findViewById(R.id.ticketGroup)).addView(editText);
            }
        });

        calculateButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LinearLayout ticketGroup = findViewById(R.id.ticketGroup);
                    Ticket[] tickets = new Ticket[ticketGroup.getChildCount()];

                    for(int i = 0; i < ticketGroup.getChildCount(); i++) {
                        EditText editText = (EditText) ticketGroup.getChildAt(i);
                        tickets[i] = new Ticket(ip.parse(editText.getText().toString()));
                    }

                    TextView resultValues = (TextView) findViewById(R.id.resultValues);
                    TextView resultFrequency = (TextView) findViewById(R.id.resultFrequency);

                    List<Tuple> ansTuple = nh.calculateDifferences(tickets);

                    List<Integer> ansValues = new ArrayList<>();
                    List<Integer> ansFrequency = new ArrayList<>();

                    for(Tuple<Integer, Integer> tuple : ansTuple) {
                        ansValues.add(tuple.second);
                        ansFrequency.add(tuple.first);
                    }

                    resultValues.setText(   "Numeros:" + ansValues.toString());
                    resultFrequency.setText("Frequencia:" + ansFrequency.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private EditText generateEditText() {
        /*
            <EditText
            android:id="@+id/ticket2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/ticket2"
            android:inputType="text" />
         */
        EditText editText = new EditText(getBaseContext());
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        );
        editText.setHint(R.string.ticketHint);
        return editText;
    }

}
