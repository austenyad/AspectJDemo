package com.austen.aspectjx.internal.model

import com.google.gson.annotations.SerializedName

class AJXExtensionConfig implements Serializable {

    @SerializedName("enabled")
    boolean enable = true
    @SerializedName("ajcArgs")
    List<String> ajcArgs = new ArrayList<>()
    @SerializedName("includes")
    List<String> includes = new ArrayList<>()
    @SerializedName("excludes")
    List<String> excludes = new ArrayList<>()
}