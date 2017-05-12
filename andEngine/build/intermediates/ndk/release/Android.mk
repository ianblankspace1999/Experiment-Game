LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := andengine_shared
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\main\jni\Android.mk \
	C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\main\jni\Application.mk \
	C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\main\jni\build.sh \
	C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\main\jni\src\BufferUtils.cpp \
	C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\main\jni\src\GLES20Fix.c \

LOCAL_C_INCLUDES += C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\main\jni
LOCAL_C_INCLUDES += C:\Users\IanBlanco\Desktop\ExperimentGame\andEngine\src\release\jni

include $(BUILD_SHARED_LIBRARY)
