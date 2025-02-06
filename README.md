# Gester Core

Core library with AIDL bound service contracts for [Gester](https://github.com/demndevel/gester/) app

# How to create new plugin

Firstly, you need to create an android app without default activity (or you can add it if you want). Then you need to add the library

```toml
[versions]
gesterCore = "0.0.11" # use latest version

[libraries]
gester-core = { module = "io.github.demndevel:gester-core", version.ref = "gesterCore" }
```

```kotlin
implementation(libs.gester.core)
```

Each plugin has its own metadata. You can create it by `buildPluginMetadata`, e.g.:

```kotlin
val wowPluginMetadata = buildPluginMetadata(
	pluginId = "Some Plugin ID",
	pluginName = "Some Plugin Name"
) {
	consumeAnyInput = true
	description = "this is a really cool plugin!!"

	version = PluginVersion(
		major = 1,
		minor = 1,
	)
}
```

As each plugin is a bound service, you should create it by using predefined `PluginService` class with open methods:

```kotlin
class WowPlugin : PluginService(wowPluginMetadata) {
	override fun executeAnyInputHandler(input: String): List<OperationResult> {
		val intent = Intent(Intent.ACTION_VIEW).apply {
			data = Uri.parse("https://github.com/demndevel/")
		}

		return if (input == "test") {
			listOf(
				BasicOperationResult(
					text = "Test result",
					intent = intent,
					label = "website",
					pinToTop = false,
				)
			)
		} else emptyList()
	}
}
```

And finally you need to make few changes to Android Manifest:

1. Declare permission

```xml
<permission android:name="com.demn.PLUGIN_SERVICE_PERMISSION" />
```

2. Add bound service with that permission and intent filter

```xml
<service
  android:name=".WowPlugin"
  android:exported="true"
  android:permission="com.demn.PLUGIN_SERVICE_PERMISSION"
  android:process=":remote">
  <intent-filter>
    <action android:name="findutil.intent.action.PICK_PLUGIN" />
    <category android:name="findutil.intent.category.ADD_PLUGIN" />
  </intent-filter>
</service>
```

### Result

![telegram-cloud-photo-size-2-5271666919973447456-y](https://github.com/user-attachments/assets/a6ae4f81-25aa-4d84-83f7-6623c559b0a6)
