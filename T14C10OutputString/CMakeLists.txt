cmake_minimum_required(VERSION 3.3)
project(T14C10OutputString)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.c)
add_executable(T14C10OutputString ${SOURCE_FILES})