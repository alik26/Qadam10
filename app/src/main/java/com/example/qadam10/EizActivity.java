package com.example.qadam10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class EizActivity extends AppCompatActivity {



    Button TolykBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eizi);


    TolykBtn = findViewById(R.id.btn8);

    TolykBtn.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View v){
        openDialog();
    }
    });
}
    private void openDialog(){
       DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "fwefwefwefjowefjwefiwejfwieiwenfiwenfwenfwefiowenfweonweinwenweonfioweniowf");
    }
}