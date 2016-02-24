//
// Created by fanqi on 16/2/24.
//
#include "xyz_fanqi_androidclog_JNIBridge.h"
#include <android/log.h>
#include <stdio.h>

#define  LOG_TAG    "OUTPUT"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

void Java_xyz_fanqi_androidclog_JNIBridge_logI
(JNIEnv *env, jclass, jstring jstr){
    const char *message=NULL;
    message = env->GetStringUTFChars(jstr, 0);
    LOGI("%s", message);
}



