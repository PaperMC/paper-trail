plugins {
    val indraVer = "3.0.1"
    id("net.kyori.indra") version indraVer
    id("net.kyori.indra.publishing") version indraVer
}

indra {
    javaVersions().target(17)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}
