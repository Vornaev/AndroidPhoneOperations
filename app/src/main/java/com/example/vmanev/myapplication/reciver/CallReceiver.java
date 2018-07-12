package com.example.vmanev.myapplication.reciver;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;


import java.util.Date;

/**
 * Created by adris on 3/14/2018.
 */

public class CallReceiver extends PhoneCallReceiver {

    public static final int DELAY_MILLIS = 1800;
    private volatile boolean mIsCallEnded = false;

    @Override
    protected void onIncomingCallStarted(final Intent intent, final Context ctx, final String number, Date start) {
        super.onIncomingCallStarted(intent, ctx, number, start);
        new Handler().postDelayed(() -> {
            Toast.makeText(ctx, number, Toast.LENGTH_LONG);
        }, DELAY_MILLIS);
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        super.onIncomingCallEnded(ctx, number, start, end);

        Intent local = new Intent();
        local.setAction("com.end.phone.action");
        ctx.sendBroadcast(local);
        mIsCallEnded = true;
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        super.onMissedCall(ctx, number, start);

        Intent local = new Intent();
        local.setAction("com.end.phone.action");
        ctx.sendBroadcast(local);
        mIsCallEnded = true;
    }

}
