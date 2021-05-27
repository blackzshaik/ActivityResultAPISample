package com.madtutorial.activityresult

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat


class HomeFragment : Fragment() {

    private val requestStoragePermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissionGranted ->

            if (permissionGranted.isNotEmpty()) {
                if (permissionGranted[permissionArray[0]]!! && permissionGranted[permissionArray[1]]!!) {
                    permissionStatusTextView.text = "Permission Granted"
                } else {
                    permissionStatusTextView.text = "User denied permission"
                }
            }
        }


    private lateinit var requestPermissionButton: Button
    private lateinit var permissionStatusTextView: TextView

    private val permissionArray = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        requestPermissionButton = view.findViewById(R.id.requestPermissionButton)
        permissionStatusTextView = view.findViewById(R.id.permissionStatusTextView)


        requestPermissionButton.setOnClickListener {
            checkStoragePermission()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkStoragePermission() {

        if (isAllPermissionGranted()) {
            permissionStatusTextView.text = "Permission Already Granted"
        } else {
            if (requireActivity().shouldShowRequestPermissionRationale(permissionArray[0])
                || requireActivity().shouldShowRequestPermissionRationale(permissionArray[1])
            ) {
                Toast.makeText(
                    requireContext(),
                    "In order to demonstrate the success scenario we need you to allow access to the permission",
                    Toast.LENGTH_LONG
                ).show()

                requestStoragePermission.launch(permissionArray)
            } else {
                requestStoragePermission.launch(permissionArray)
            }
        }

    }
    

    private fun isAllPermissionGranted(): Boolean {
        permissionArray.forEach {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    it
                ) == PackageManager.PERMISSION_DENIED
            ) {
                return false
            }
        }
        return true
    }
}