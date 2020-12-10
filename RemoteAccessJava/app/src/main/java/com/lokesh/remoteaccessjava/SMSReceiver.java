package com.lokesh.remoteaccessjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("adnan", "on receive");
        String phoneNumbers = PreferenceManager.getDefaultSharedPreferences(
                context).getString("phone_entries", "");
        StringTokenizer tokenizer = new StringTokenizer(phoneNumbers, ",");
        Set<String> phoneEnrties = new HashSet<String>();
        while (tokenizer.hasMoreTokens()) {
            phoneEnrties.add(tokenizer.nextToken().trim());
        }
        Bundle bundle = intent.getExtras();
        Object[] pdus = new Object[0];
        if (bundle != null) {
            pdus = (Object[]) bundle.get("pdus");
        }
        SmsMessage[] messages = new SmsMessage[pdus.length];
        for (int i = 0; i < messages.length; i++) {
            Log.d("adnan", "message.length for loop");
            messages[i]= SmsMessage.createFromPdu((byte[]) pdus[i]);
            String address = messages[i].getOriginatingAddress();
            Log.d("adnan", address);
            Log.d("adnan", messages[i].getDisplayMessageBody());

            if (phoneEnrties.contains(address)) {
                Intent newintent = new Intent(context, MainActivity.class);
                newintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                newintent.putExtra("address", address);
                newintent.putExtra("message",
                        messages[i].getDisplayMessageBody());

                context.startActivity(newintent);
            }
        }
    }
}
