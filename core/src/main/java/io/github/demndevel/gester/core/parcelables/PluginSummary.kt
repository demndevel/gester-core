package io.github.demndevel.gester.core.parcelables

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PluginSummary(
	val pluginId: String,
	val pluginVersion: PluginVersion,
) : Parcelable
