cmake_minimum_required(VERSION 3.3)
project(T14C09Logic)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.c)
add_executable(T14C09Logic ${SOURCE_FILES})