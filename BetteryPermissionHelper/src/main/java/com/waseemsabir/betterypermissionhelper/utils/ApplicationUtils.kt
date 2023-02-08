package com.waseemsabir.betterypermissionhelper.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build

val Context.applicationName: String
  get() {
    val applicationInfo = this.applicationInfo
    val stringId = applicationInfo.labelRes
    return if (stringId == 0) applicationInfo.nonLocalizedLabel.toString()
    else this.getString(stringId)
  }

fun Context.getIntentActivities(
    intent: Intent,
    flag: Int = PackageManager.MATCH_DEFAULT_ONLY
): List<android.content.pm.ResolveInfo> {
  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    this.packageManager.queryIntentActivities(
        intent, PackageManager.ResolveInfoFlags.of(flag.toLong()))
  } else {
    this.packageManager.queryIntentActivities(intent, flag)
  }
}
