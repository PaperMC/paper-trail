plugins {
    val indraVer = "3.0.1"
    id("net.kyori.indra") version indraVer
    id("net.kyori.indra.publishing") version indraVer
}

java {
    disableAutoTargetJvm()
}

indra {
    javaVersions {
        target(8)
        minimumToolchain(17)
    }
    publishSnapshotsTo("paperSnapshots", "https://repo.papermc.io/repository/maven-snapshots/")
    publishReleasesTo("paper", "https://repo.papermc.io/repository/maven-releases/")
    mitLicense()
    github("PaperMC", "paper-trail")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}
