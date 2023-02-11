package com.annotations;

import java.lang.reflect.Method;


// https://www.infoworld.com/article/3543240/how-to-describe-java-code-with-annotations.html
public class ProcessAnnotations {
    public static void main(String[] args) throws Exception{
        if(args.length != 1) {
            System.err.println("Usage: java ProcessAnnotations classfile");
            return;
        }
        Method[] methods = Class.forName(args[0]).getMethods();
        for(int i = 0; i < methods.length; i++) {
            if(methods[i].isAnnotationPresent(ProgramMarkers.class)) {
                ProgramMarkers markers = methods[i].getAnnotation(ProgramMarkers.class);
                System.out.println(markers.annotationType().getTypeParameters());
            }
        }
    }
}
