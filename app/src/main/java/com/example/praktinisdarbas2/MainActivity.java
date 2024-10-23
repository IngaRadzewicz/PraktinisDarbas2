package com.example.praktinisdarbas2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.praktinisdarbas2.utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    private EditText edUserInput;
    private TextView tvResult;
    private Spinner spCountOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.edUserInput =  findViewById(R.id.edUserInput);
        this.tvResult =  findViewById(R.id.tvResult);
        this.spCountOptions =  findViewById(R.id.spCountOptions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.counting_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String userInputPhrase = this.edUserInput.getText().toString();

        // Patikrinama, ar įvesties laukas nėra tuščias
        if (userInputPhrase.isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.empty_input_warning), Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedOption = this.spCountOptions.getSelectedItem().toString();

        if (selectedOption.equals(getResources().getString(R.string.option_chars))) {
            int result = TextCounter.getCharsCount(userInputPhrase);
            this.tvResult.setText(String.valueOf(result));
        } else if (selectedOption.equals(getResources().getString(R.string.option_words))) {
            int result = TextCounter.getWordsCount(userInputPhrase);
            this.tvResult.setText(String.valueOf(result));
        } else {
            this.tvResult.setText(R.string.message_not_implemented);
        }
    }
}
