################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/T14C14IncludeLoop.c \
../src/a.c \
../src/b.c 

OBJS += \
./src/T14C14IncludeLoop.o \
./src/a.o \
./src/b.o 

C_DEPS += \
./src/T14C14IncludeLoop.d \
./src/a.d \
./src/b.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


