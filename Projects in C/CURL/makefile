CFLAGS=-g -c -Wall -Wextra -Wwrite-strings -lcurl -c
LFLAGS=-g -Wall -Wextra -lcurl -o

prog3: prog3_funcs.o prog3.o
	gcc ${LFLAGS} prog3 prog3_funcs.o prog3.o
prog3.o: prog3_funcs.h prog3.c
	gcc ${CFLAGS} prog3.c
prog3_funcs.o: prog3_funcs.h prog3_funcs.c
	gcc ${CFLAGS} prog3_funcs.c
clean:
	rm -f *.o
	rm -f prog3