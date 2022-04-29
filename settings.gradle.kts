dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "kplot"
include(":sample")
include(":lib")
