cmake_minimum_required(VERSION 3.3)
project(T14C07CustomType)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(T14C07CustomType ${SOURCE_FILES})