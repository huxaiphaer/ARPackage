package com.example.ar_newvision;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "samples.flutter.dev/battery";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            // Note: this method is invoked on the main thread.

                            if (call.method.equals("getBatteryLevel")) {
                                launchFirstActivity();
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }


    private void launchFirstActivity() {

        Intent i = new Intent(MainActivity.this, LauncherActivity.class);
        startActivity(i);
    }

}
