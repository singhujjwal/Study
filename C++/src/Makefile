CC=g++
ODIR=.
_OBJ =  assignment.o 
OBJ = $(patsubst %,$(ODIR)/%,$(_OBJ))


$(ODIR)/%.o: assignment.cpp 
	$(CC) -c -o assignment.o assignment.cpp 

assignment: $(OBJ)
	g++ -o $@ $^ 

.PHONY: clean

clean:
	rm -f $(ODIR)/*.o *~ core  
