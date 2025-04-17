package com.example.chromou.utils

import android.Manifest
import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.annotation.RequiresPermission
import androidx.palette.graphics.Palette

object WallpaperUtils {
    @RequiresPermission(anyOf = ["android.permission.READ_WALLPAPER_INTERNAL", Manifest.permission.MANAGE_EXTERNAL_STORAGE])
    fun getDominantColorFromWallpaper(context: Context): Int {
        val wallpaperManager = WallpaperManager.getInstance(context)
        val wallpaperDrawable = wallpaperManager.drawable

        if (wallpaperDrawable is BitmapDrawable) {
            val bitmap: Bitmap = wallpaperDrawable.bitmap
            val palette = Palette.from(bitmap).generate()
            return palette.getDominantColor(0xFF000000.toInt()) // Default to black if no color is found
        }
        return 0xFF000000.toInt() // Default to black
    }
}