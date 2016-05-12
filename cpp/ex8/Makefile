FLAGS = -std=gnu++11 -Wreturn-type -pedantic -pedantic-errors -Wundef
CPP=g++

build: main.o map.o
	$(CPP) $(FLAGS) -o main.x map.o main.o

main.o: map.h main.cpp
	$(CPP) -c $(FLAGS) main.cpp -o main.o
map.o: map.h map.cpp
	$(CPP) -c $(FLAGS) map.cpp -o map.o
clean:
	rm *.o
	rm main.x