@file:JvmName("DeviceSugar")

package com.moka.lib.internals

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.test.platform.app.InstrumentationRegistry
import timber.log.Timber

fun printAvailableScreenSpace() {
    val windowManager = InstrumentationRegistry.getInstrumentation().context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    val displayMetrics = DisplayMetrics().apply { windowManager.defaultDisplay.getMetrics(this) }

    val densityDpi = displayMetrics.densityDpi
    val outSmallestSize = Point()
    val outLargestSize = Point()

    windowManager.defaultDisplay.getCurrentSizeRange(outSmallestSize, outLargestSize)

    Timber.d("dpi: $densityDpi\nPortrait: ${outLargestSize.y} high by ${outSmallestSize.x} wide")
}
