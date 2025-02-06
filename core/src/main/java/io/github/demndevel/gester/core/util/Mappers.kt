package io.github.demndevel.gester.core.util

import android.os.ParcelUuid
import java.util.*

fun UUID.toParcelUuid(): ParcelUuid = ParcelUuid(this)
