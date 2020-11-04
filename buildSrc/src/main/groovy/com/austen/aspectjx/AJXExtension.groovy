package com.austen.aspectjx

class AJXExtension {
    List<String> includes = new ArrayList<>()
    List<String> excludes = new ArrayList<>()

    List<String> ajcArgs = new ArrayList<>()

    boolean enabled = true

    AJXExtension include(String... filters) {
        if (filters != null) {
            this.includes.addAll(filters)
        }
        return this
    }

    AJXExtension exclude(String... filters) {
        if (filters != null) {
            this.excludes.addAll(filters)
        }
        return this
    }

    AJXExtension ajcArgs(String... ajcArgs) {
        if (ajcArgs != null) {
            this.ajcArgs.addAll(ajcArgs)
        }
        return this
    }


    @Override
    public String toString() {
        return "AJXExtension{" +
                "includes=" + Arrays.toString(includes) +
                ", excludes=" + Arrays.toString(excludes) +
                ", ajcArgs=" + Arrays.toString(ajcArgs) +
                ", enabled=" + enabled +
                '}';
    }
}