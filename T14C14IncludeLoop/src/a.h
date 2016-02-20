/*
 * a.h
 *
 *  Created on: 2016年2月20日
 *      Author: fanqi
 */
#pragma once
/*
 * 防止头文件重复引入
 * 方法1：#ifndef A_H_，编译较慢
 * 如果没有定义A_H_ 则编译 A_H_的定义代码
 * 如果定义了A_H_ 则不重复编译
 *
 * 方法2：新型方式，编译较快
 * #pragma once
 *
 */
//#ifndef A_H_
//#define A_H_
#include "b.h"

void funcA();
void funcA1();
void funcA2();

//#endif /* A_H_ */
