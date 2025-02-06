import com.vanniktech.maven.publish.SonatypeHost

plugins {
	id("com.android.library")
	kotlin("android")
	id("kotlin-parcelize")
	id("signing")
	id("com.vanniktech.maven.publish") version "0.30.0"
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

mavenPublishing {
	publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

	signAllPublications()

	coordinates("io.github.demndevel", "gester-core", "0.0.11")

	pom {
		name.set("Gester Core")
		description.set("Library that allows you to create your own plugins for Gester app")
		inceptionYear.set("2025")
		url.set("https://github.com/demndevel/gester-core/")
		licenses {
			license {
				name.set("The Apache License, Version 2.0")
				url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
				distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
			}
		}
		developers {
			developer {
				id.set("demndevel")
				name.set("demn")
				url.set("https://github.com/demndevel/")
			}
		}
		scm {
			url.set("https://github.com/demndevel/gester-core/")
			connection.set("scm:git:git://github.com/demndevel/gester-core.git")
			developerConnection.set("scm:git:ssh://git@github.com/demndevel/gester-core.git")
		}
	}
}

signing {
	val keyId = System.getenv("ORG_GRADLE_PROJECT_signingInMemoryKeyId")
	val signingKey = System.getenv("ORG_GRADLE_PROJECT_signingInMemoryKey")
	val keyPassword = System.getenv("ORG_GRADLE_PROJECT_signingInMemoryKeyPassword")

	useInMemoryPgpKeys(
		keyId,
		signingKey,
		keyPassword,
	)

	sign(publishing.publications)
}
