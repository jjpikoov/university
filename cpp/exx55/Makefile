
# Automatically generated Makefile
# Makefile-generator programmed by Hans de Nivelle, 2002


Flags = -Wreturn-type -pedantic -pedantic-errors -Wundef -std=c++11
CPP = g++


main : Makefile   tree.o main.o 
	$(CPP) $(Flags) -g -o main.x   tree.o main.o 

tree.o : Makefile   tree.cpp   tree.h 
	$(CPP) -c -g $(Flags) tree.cpp -o  tree.o


main.o : Makefile   main.cpp   tree.h 
	$(CPP) -c -g $(Flags) main.cpp -o  main.o
clean:
	rm *.o main.x
	


