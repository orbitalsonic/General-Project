package com.orbitalsonic.generalproject.helpers.datetime

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 Commonly Used Date Formats:

 1. "EEE, dd MMM, yyyy"      -> Sun, 09 Feb, 2025
 2. "EEEE, dd MMMM, yyyy"    -> Sunday, 09 February, 2025
 3. "dd MMM yyyy"            -> 09 Feb 2025
 4. "dd/MM/yyyy"             -> 09/02/2025
 5. "MM/dd/yyyy"             -> 02/09/2025
 6. "yyyy-MM-dd"             -> 2025-02-09
 7. "yyyy/MM/dd"             -> 2025/02/09
 8. "dd-MM-yyyy"             -> 09-02-2025
 9. "dd MMMM yyyy"           -> 09 February 2025
10. "MMM dd, yyyy"           -> Feb 09, 2025
11. "EEEE, MMM dd, yyyy"     -> Sunday, Feb 09, 2025
12. "EEE, MMM dd, yyyy hh:mm a" -> Sun, Feb 09, 2025 08:30 AM
13. "yyyyMMdd"               -> 20250209
14. "HH:mm:ss"               -> 14:30:45 (24-hour format)
15. "hh:mm a"                -> 02:30 PM

**/


fun getCurrentDate(format:String):String{
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val currentDate = Date()
    val formattedDate = dateFormat.format(currentDate)
    return formattedDate
}