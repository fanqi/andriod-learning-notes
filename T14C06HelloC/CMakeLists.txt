cmake_minimum_required(VERSION 3.3)
project(T14C06HelloC)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.c)
add_executable(T14C06HelloC ${SOURCE_FILES})