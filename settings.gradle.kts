pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "simple-diary-planner"
include(":app")
include(":app:core_data")
include(":app:core_base")
include(":app:core_navigation")
include(":app:core_model")
include(":app:feature_calendar")
include(":app:feature_create_task")
include(":app:feature_task_detail")
