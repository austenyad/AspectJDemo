package com.austen.aspectjx

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.austen.aspectjx.internal.TimeTrace
import org.gradle.api.Plugin
import org.gradle.api.Project


class AJXPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println "Hello plugin..." + project.name
        project.repositories {
            mavenLocal()
        }

        project.dependencies {
            if (project.gradle.gradleVersion > "4.0") {
                project.logger.debug("gradlew version > 4.0")
                implementation 'org.aspectj:aspectjrt:1.9.5'
            } else {
                project.logger.debug("gradlew version < 4.0")
                compile 'org.aspectj:aspectjrt:1.9.5'
            }
        }

        project.extensions.create("aspectjx", AJXExtension)
        if (project.plugins.hasPlugin(AppPlugin)) {
            // 构建时间跟踪
            project.gradle.addListener(new TimeTrace())

            //注册 AspectTransform
            AppExtension android = project.extensions.getByType(AppExtension)
            android.registerTransform(new AJXTransform())
        }
    }
}