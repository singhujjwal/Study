IDIR =../include
CC=g++
CFLAGS=-I$(IDIR)

ODIR=.
LDIR =../lib

_DEPS = make.h
DEPS = $(patsubst %,$(IDIR)/%,$(_DEPS))

_OBJ = assignment.o 
OBJ = $(patsubst %,$(ODIR)/%,$(_OBJ))


$(ODIR)/%.o: %.cpp $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

assignment: $(OBJ)
	gcc -o $@ $^ $(CFLAGS)

.PHONY: clean

clean:
	rm -f $(ODIR)/*.o *~ core $(INCDIR)/*~ 
