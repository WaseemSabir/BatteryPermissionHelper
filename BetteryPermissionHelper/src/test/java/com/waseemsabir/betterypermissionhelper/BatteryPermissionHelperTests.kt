package com.waseemsabir.betterypermissionhelper

import android.content.Context
import android.content.pm.PackageManager
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BatteryPermissionHelperTests {
  @Test
  fun nonSupportedDevice() {
    val batteryPermissionHelper = BatteryPermissionHelper.getInstance()
    // Create a mock Context object
    val context = mock(Context::class.java)
    val packageManager = mock(PackageManager::class.java)
    `when`(context.packageManager).thenReturn(packageManager)

    assert(batteryPermissionHelper.isBatterySaverPermissionAvailable(context).not())
  }
}
