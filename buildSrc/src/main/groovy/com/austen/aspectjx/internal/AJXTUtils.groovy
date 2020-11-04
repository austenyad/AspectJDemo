package com.austen.aspectjx.internal

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.apache.commons.io.FileUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter

class AJXUtils {
    static Gson gson = new GsonBuilder().create()

    static boolean isAspectClass(File classFile) {
        if (isClassFile(classFile)) {
            return isAspectClass(FileUtils.readFileToByteArray(classFile))
        }
        return false
    }

    static boolean isAspectClass(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return false
        }

        try {
            ClassReader classReader = new ClassReader(bytes)
            ClassWriter classWriter = new ClassWriter(classReader,
                    ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES)


        } catch (Exception e) {
        }

    }

    static boolean isClassFile(String filepath) {
        return filepath?.toLowerCase()?.endsWith('.class')
    }

}