package com.example.keymapper

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent

const val filmixButton = 265       // KEYCODE_STEM_1
const val smartTubeButton = 247    // KEYCODE_TV_INPUT_COMPOSITE_1

const val TAG = "mapper"

class Mapper : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        return
    }

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        if (event == null) {
            return false
        }

        Log.v(
            TAG,
            "key=${KeyEvent.keyCodeToString(event.keyCode)} code=${event.keyCode} scan=${event.scanCode}"
        )
        if (event.action == KeyEvent.ACTION_DOWN) {
            when (event.keyCode) {
                filmixButton -> {
                    Runner(this).runPackage("net.filmix.filmix")
                }

                smartTubeButton -> {
                    Runner(this).runPackage("org.smarttube.stable")
                }            }
        }

        return super.onKeyEvent(event)
    }

    override fun onInterrupt() {
        return
    }
}



