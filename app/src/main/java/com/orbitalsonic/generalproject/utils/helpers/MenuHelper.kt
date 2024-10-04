package com.orbitalsonic.generalproject.utils.helpers

import android.annotation.SuppressLint
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.Menu
import android.widget.PopupMenu
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.forEach
import java.lang.reflect.Method

/*    @SuppressLint("RestrictedApi")
    fun Context.setIconVisibleOrTint(menu: Menu) {
        try {
            (menu as MenuBuilder).setOptionalIconsVisible(true)
            val typedArray = theme.obtainStyledAttributes(intArrayOf(R.attr.colorOnCard1))
            val color:Int = typedArray.getColor(0, 0)
            typedArray.recycle()

            if (menu.javaClass.simpleName == "MenuBuilder") {
                try {
                    val m: Method = menu.javaClass.getDeclaredMethod(
                        "setOptionalIconsVisible", java.lang.Boolean.TYPE
                    )
                    m.isAccessible = true
                    m.invoke(menu, true)
                } catch (ignored: NoSuchMethodException) {
                } catch (ignored: Exception) {
                }
            }
            setIconTint(menu, color)
        } catch (ignored: Exception) {}

    }*/

@SuppressLint("RestrictedApi")
fun setIconVisible(menu: Menu) {
    try {
        (menu as MenuBuilder).setOptionalIconsVisible(true)
        if (menu.javaClass.simpleName == "MenuBuilder") {
            try {
                val m: Method = menu.javaClass.getDeclaredMethod(
                    "setOptionalIconsVisible", java.lang.Boolean.TYPE
                )
                m.isAccessible = true
                m.invoke(menu, true)
            } catch (ignored: NoSuchMethodException) {}
            catch (ignored: Exception) {}
        }
    } catch (ignored: Exception) {}
}

@SuppressLint("RestrictedApi", "DiscouragedPrivateApi")
fun setIconVisiblePopup(popupMenu: PopupMenu) {
    try {
        val field = PopupMenu::class.java.getDeclaredField("mPopup")
        field.isAccessible = true
        val popup = field.get(popupMenu)
        popup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
            .invoke(popup, true)
    } catch (ignore: Exception) {}

}

/*    @SuppressLint("RestrictedApi", "DiscouragedPrivateApi")
    fun Context.setIconVisibleOrTintPopup(popupMenu: PopupMenu) {
        try {
            val typedArray = theme.obtainStyledAttributes(intArrayOf(R.attr.colorOnCard1))
            val color:Int = typedArray.getColor(0, 0)
            typedArray.recycle()

            val field = PopupMenu::class.java.getDeclaredField("mPopup")
            field.isAccessible = true
            val popup = field.get(popupMenu)
            popup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(popup, true)

            setIconTint(popupMenu.menu, color)
        } catch (ignore: Exception) {}

    }*/

fun setIconTint(menu: Menu, color: Int) {
    try {
        menu.forEach {
            val drawable = it.icon
            if (drawable != null) {
                drawable.mutate()
                setThemeColorFilter(drawable, color)
            }
        }
    } catch (ignored: Exception) {}
}

/*  fun Context.setIconTint(menuItem: MenuItem) {
      try {
          val typedArray = theme.obtainStyledAttributes(intArrayOf(R.attr.colorOnCard1))
          val color:Int = typedArray.getColor(0, 0)
          typedArray.recycle()

          val drawable = menuItem.icon
          if (drawable != null) {
              drawable.mutate()
              setThemeColorFilter(drawable, color)
          }
      } catch (ignored: Exception) {}
  }*/

fun setThemeColorFilter(drawable: Drawable, colorId: Int) {
    try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(colorId, BlendMode.SRC_ATOP)
        } else {
            drawable.colorFilter = PorterDuffColorFilter(colorId, PorterDuff.Mode.SRC_ATOP)
        }
    } catch (ignored: Exception) {}
}