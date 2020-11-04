package com.austen.aspectjx.internal.cache

import com.android.builder.model.AndroidProject
import com.austen.aspectjx.internal.model.AJXExtensionConfig
import org.gradle.api.Project


class AJXCache{
    Project project
    String cachePath
    Map<String,VariantCache> variantCacheMap = new HashMap<>()

    String extensionConfigPath

    AJXExtensionConfig ajxExtensionConfig = new AJXExtensionConfig()

    //
    String encoding
    String bootClassPath
    String sourceCompatibility
    String targetCompatibility

    AJXCache(Project project) {
        this.project = project
        init()
    }
    private void init(){
        cachePath = project.buildDir.absolutePath + File.separator + AndroidProject.FD_INTERMEDIATES + "/ajx"
        extensionConfigPath = cachePath + File.separator + "extensionconfig.json"
        if (!cacheDir.exists()){
            cacheDir.mkdirs()
        }

        File extensionConfig = new File(extensionConfigPath)
        if (extensionConfig.exists()){
            ajxExtensionConfig =
        }
    }

    File getCacheDir(){
        return new File(cachePath)
    }
}