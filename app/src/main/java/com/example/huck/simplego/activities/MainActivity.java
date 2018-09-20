package com.example.huck.simplego.activities;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.example.huck.simplego.R;

public class MainActivity extends AppCompatActivity {

    Button toBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toBoard = findViewById(R.id.board_button);

        toBoard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, BoardActivity.class));
            }
        });
    }
}
