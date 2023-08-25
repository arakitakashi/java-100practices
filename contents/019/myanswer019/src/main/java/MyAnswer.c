#include <jni.h>
#include <stdlib.h>

JNIEXPORT jint JNICALL Java_RandomNumberGenerator_getRandomNumber(JNIEnv *env, jobject obj) {
    return rand() % 8;
}
