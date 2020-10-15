LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_SRC_FILES := camera.shim.c
LOCAL_MODULE := camera.shim
LOCAL_MODULE_TAGS := optional
LOCAL_VENDOR_MODULE := true
include $(BUILD_SHARED_LIBRARY) 
