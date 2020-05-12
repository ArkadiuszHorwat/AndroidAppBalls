package com.example.ballsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class RankingActivity extends AppCompatActivity {

    Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        cont = this;

        String zawartoscRank = "";
        String fileName = "rank.txt";
        FileInputStream fis = null;
        TextView twRanking = (TextView) findViewById(R.id.twRanking);

        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            for(int i=1; i<11; i++)
            {
                String line = br.readLine();
                if(line!=null)
                {
                    zawartoscRank += i;
                    zawartoscRank += ". ";
                    zawartoscRank += line;
                    zawartoscRank += "\n";
                }

            }
            twRanking.setText(zawartoscRank);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        Button bReturn = (Button) findViewById(R.id.bReturn);
        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
