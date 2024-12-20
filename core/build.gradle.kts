plugins {
	id("com.android.library")
	kotlin("android")
	id("kotlin-parcelize")
	`maven-publish`
}

android {
	namespace = "com.github.demndevel.gester.core"
	compileSdk = 34

	defaultConfig {
		aarMetadata {
			minSdk = 29
		}

		minSdk = 29

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	buildFeatures {
		aidl = true
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

dependencies {
	testImplementation(kotlin("test"))
}

publishing {
	publications {
		register<MavenPublication>("release") {
			groupId = "com.github.demndevel"
			artifactId = "gester-core"
			version = "0.0.9"
			pom {
				description = "first release!!"
			}
		}
	}
	repositories {
		mavenLocal()
	}
}