package com.austen.aspectjx.internal

import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes

class AspectJClassVisitor extends ClassVisitor {
    boolean isAspectClass = false

    AspectJClassVisitor(ClassWriter classWriter) {
        super(Opcodes.ASM5, classWriter)
    }

    AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        isAspectClass |= (desc == 'Lorg/aspectj/lang/annotation/Aspect;')
        return super.visitAnnotation(desc, visible)
    }
}