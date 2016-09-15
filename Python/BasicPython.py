#!/usr/bin/python

# Prints all the globals defined in the python environment
print globals()


try:
    a = 2/0
except Exception as e:
    print "printing exception"
    print str(e)