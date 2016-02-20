/*
 ============================================================================
 Name        : T14C16StructPointer.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : 结构体指针，可作为面向对象的原型
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct _Student{
	char *name;
	int age;
} Student;

void func(){
	Student s1 = {"fanqi",1};//局部变量，最近的{}执行完成之后会被销毁
	Student s2 = s1;//赋值之后，系统会创建新的内存，将s1的内容复制到s2，s1和s2不同
	s2.age = 20;
	//如果希望s1和s2相同则需要使用指针
	Student *s3 = &s1;
	printf("(s1.name=%s,s1.age=%d),(s2.name=%s,s2.age=%d)\n",s1.name,s1.age,s2.name,s2.age);
	//访问结构体指针的成员需要使用->
	s3->age =22;
	printf("(s1.name=%s,s1.age=%d),(s3.name=%s,s3.age=%d)\n",s1.name,s1.age,s3->name,s3->age);
}

Student *createStudent(char *name,int age){
	Student *s = malloc(sizeof(Student));
	s->name=name;
	s->age =age;
	return s;
}

void deleteStudent(Student *s){
	free(s);
}

int main(void) {
	func();
	Student *s4 = createStudent("s4",4);
	printf("(s4.name=%s,s4.age=%d)\n",s4->name,s4->age);
	deleteStudent(s4);

	return EXIT_SUCCESS;
}
