package com.sergiocasero.dexterpermissions.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sergiocasero.dexterpermissions.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();

        checkPermissions();

        checkWithDialogAndSnackbar();

        checkPermissionsWithArray();
    }

    private void checkPermissionsWithArray() {

        permissions = getResources().getStringArray(R.array.permissions);

        Dexter.checkPermissions(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {

                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }
        }, permissions);
    }

    private void checkWithDialogAndSnackbar() {
        MultiplePermissionsListener dialogPermissionListener = DialogOnAnyDeniedMultiplePermissionsListener.Builder
                .withContext(this)
                .withTitle("Multiple permissions")
                .withMessage("We need this permissions for...")
                .withButtonText(android.R.string.ok)
                        //.withIcon(R.mipmap.my_icon)
                .build();

        Dexter.checkPermissions(dialogPermissionListener, Manifest.permission.READ_CONTACTS, Manifest.permission.RECORD_AUDIO);
    }

    private void checkPermissions() {
        Dexter.checkPermissions(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {

                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }
        }, Manifest.permission.READ_CONTACTS, Manifest.permission.RECORD_AUDIO);
    }

    private void checkPermission() {
        Dexter.checkPermission(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

            }
        }, Manifest.permission.ACCESS_COARSE_LOCATION);
    }
}
