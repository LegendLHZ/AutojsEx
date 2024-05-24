package org.autojs.autojs.core.image.capture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.autojs.autojs.app.OnActivityResultDelegate;
import org.autojs.autojs.tool.IntentExtras;

/**
 * Created by Stardust on May 22, 2017.
 */
public class ScreenCaptureRequestActivity extends Activity {

    private final OnActivityResultDelegate.Mediator mOnActivityResultDelegateMediator = new OnActivityResultDelegate.Mediator();
    private ScreenCaptureRequester mScreenCaptureRequester;
    private ScreenCaptureRequester.Callback mCallback;

    public static void request(Context context, ScreenCaptureRequester.Callback callback) {
        Intent intent = getIntent(context)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        IntentExtras.newExtras()
                .put("callback", callback)
                .putInIntent(intent);
        context.startActivity(intent);
    }

    @NonNull
    public static Intent getIntent(Context context) {
        return new Intent(context, ScreenCaptureRequestActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentExtras extras = IntentExtras.fromIntentAndRelease(getIntent());
        if (extras == null) {
            finish();
            return;
        }
        mCallback = extras.get("callback");
        if (mCallback == null) {
            finish();
            return;
        }
        mScreenCaptureRequester = new ScreenCaptureRequester.ActivityScreenCaptureRequester(mOnActivityResultDelegateMediator, this);
        mScreenCaptureRequester.setOnActivityResultCallback(mCallback);
        mScreenCaptureRequester.request();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCallback = null;
        if (mScreenCaptureRequester == null)
            return;
        mScreenCaptureRequester.cancel();
        mScreenCaptureRequester = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mOnActivityResultDelegateMediator.onActivityResult(requestCode, resultCode, data);
        finish();
    }

}