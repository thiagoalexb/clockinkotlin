package com.thiagoalex.dev.clockin.ui.address.ask_location

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.thiagoalex.dev.clockin.R
import permissions.dispatcher.*

@RuntimePermissions
class AskLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_ask_location, container, false)
    }

    @NeedsPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    fun askPermission(){
        Log.d("", "askPermission: ")
    }

    @OnShowRationale(Manifest.permission.ACCESS_COARSE_LOCATION)
    fun showRationaleForCamera(request: PermissionRequest) {
        Toast.makeText(context, "NUN SEI", Toast.LENGTH_SHORT).show()
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_COARSE_LOCATION)
    fun onCameraDenied() {
        Toast.makeText(context, "NEGADO", Toast.LENGTH_SHORT).show()
    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_COARSE_LOCATION)
    fun onCameraNeverAskAgain() {
        Toast.makeText(context, "NEGADO SEMPRE", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }
}