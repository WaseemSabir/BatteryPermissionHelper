package com.waseemsabir.batterypermissionexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.waseemsabir.batterypermissionexample.databinding.ActivityMainBinding
import com.waseemsabir.betterypermissionhelper.BatteryPermissionHelper

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val batteryPermissionHelper by lazy { BatteryPermissionHelper() }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val isBatteryPermissionAvailable =
        batteryPermissionHelper.isBatterySaverPermissionAvailable(this, true)

    binding.permissionTextView.text =
        if (isBatteryPermissionAvailable) {
          "Battery Permission Available for this Device."
        } else {
          "No Battery Permission Available for this Device."
        }
    binding.permissionTextView.visibility = View.VISIBLE
    binding.openButton.visibility = if (isBatteryPermissionAvailable) View.VISIBLE else View.GONE
    binding.openButton.setOnClickListener {
      batteryPermissionHelper.getPermission(this, open = true, newTask = true)
    }
  }
}
