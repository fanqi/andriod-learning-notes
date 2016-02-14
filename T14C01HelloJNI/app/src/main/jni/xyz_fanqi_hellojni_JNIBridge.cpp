//
// Created by fanqi on 16/2/14.
//
#include "xyz_fanqi_hellojni_JNIBridge.h"
jstring Java_xyz_fanqi_hellojni_JNIBridge_getString
        (JNIEnv *env, jclass){
    return env->NewStringUTF("Hello NDK");
}



