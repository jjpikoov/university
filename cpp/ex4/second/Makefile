FLAGS = -Wreturn-type -pedantic -pedantic-errors -Wundef -std=c++11
CC = g++

main.x: main.o stack.o
	$(CC) $(FLAGS) -o main.x main.o stack.o
main.o: main.cpp
	$(CC) $(FLAGS) -c main.cpp -o main.o
stack.o: stack.cpp stack.h
	$(CC) $(FLAGS) -c stack.cpp -o stack.o
clean:
	rm *.o
	rm main.x
