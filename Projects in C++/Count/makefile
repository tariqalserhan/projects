CXX = g++
CFLAGS = -g -c -Wall -Wextra -Wwrite-strings
LFLAGS = -g
prog4 : prog4_funcs.o Count.o prog4.o
	${CXX} ${LFLAGS} -o prog4 prog4_funcs.o prog4.o Count.o
prog4.o : prog4.cpp Count.h prog4_funcs.h
	${CXX} ${CFLAGS} prog4.cpp 
prog4_funcs.o :prog4_funcs.h prog4_funcs.cpp Count.h
	${CXX} ${CFLAGS} prog4_funcs.cpp
Count.o : Count.h Count.cpp
	${CXX} ${CFLAGS} Count.cpp
clean:
	rm -f *.o
	rm -f prog4