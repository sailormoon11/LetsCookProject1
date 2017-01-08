package com.julia_sk.letscooktest.MainMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.julia_sk.letscooktest.R;
import com.julia_sk.letscooktest.SearchMenu.ActivityMeat;

/**
 * Created by Юлия on 23.11.2016.
 */

public class ActivitySearch extends Activity implements View.OnClickListener {
    Button btnMeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.search );

        btnMeat = (Button) findViewById( R.id.btnMeat );
        btnMeat.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMeat:
                Intent intent = new Intent( this, ActivityMeat.class );
                startActivity( intent );
                break;

        }
    }
}
