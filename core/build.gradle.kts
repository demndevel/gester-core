plugins {
	id("com.android.library")
	kotlin("android")
	id("kotlin-parcelize")
	`maven-publish`
}

android {
	namespace = "io.github.demndevel.gester.core"
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
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
}

dependencies {
	testImplementation(kotlin("test"))
}

publishing {
	publications {
		register<MavenPublication>("release") {
		}
	}
	repositories {
		maven {
			name = "core"
			url = uri(layout.buildDirectory.dir("repo"))
		}
	}
}

tasks.register<Zip>("generateRepo") {
	val publishTask = tasks.named(
		"publishReleasePublicationToMyrepoRepository",
		PublishToMavenRepository::class.java
	)
	from(publishTask.map { it.repository.url })
	into("gester")
	archiveFileName.set("gester-core.zip")
}