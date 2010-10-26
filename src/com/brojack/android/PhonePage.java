package com.brojack.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

public class PhonePage extends Activity{
	
	TextView txtOwnNumber;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        txtOwnNumber = (TextView) findViewById(R.id.txtOwnNumber);
        doPhoneNumber();

    }
    
    public void doPhoneNumber() {
    	txtOwnNumber.setText("Phone number: " + getOwnPhoneNumber());
    }
    
    private String getOwnPhoneNumber() {
    	TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    	return tMgr.getLine1Number();
    }
}
