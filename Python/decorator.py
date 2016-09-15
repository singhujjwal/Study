

'''
Decorators in python
'''


# def outer(somefunc):
#     def inner():
#         print "in the inner function before somefunc"
#         ret = somefunc();
#         return ret+1
#     return inner
# 
# 
# def foo():
#     return 10
# 
# decorated = outer(foo)
# decorated()


'''
Generic decorator
'''

def logger(func):
    def inner(*args, **kwargs):
        for arg in args:
            print arg
        for k,v in kwargs.iteritems():
            print( "%s->%s"%(k,v))
        print "Inner function Arguments are %s %s" %(args, kwargs)
        return func(*args, **kwargs)
    return inner

@logger
def foo1(x,y=1, **kwargs):
    return x*y


print foo1(3,23, name='Singh')


print "--"*30
print "-"*20, "ITERATORS", "-"*20
class reverse_iter:
    def __init__(self, list_input):
        self.ll = list_input
        self.i = len(list_input)
    
    def __iter__(self):
        return self;
    
    def next(self):
        if self.i >= 0:
            self.i -= 1
            return self.ll[self.i]
        else:
            raise StopIteration()
        
        
ll = [32,23,11,311,53,523]
newiter = reverse_iter(ll)
print newiter
print newiter.next()
print newiter.next()
print newiter.next()



print "--"*30

print "-"*20, "GENERATORS", "-"*20



def yrange(n):
    i = 0
    while i < n:
        yield i
        i += 1
        
        
        
ll = yrange(100)
print ll 
zz = [i for i in yrange(100)]
print zz
    
    
def integers():
    """Infinite sequence of integers."""
    i = 1
    while True:
        yield i
        i = i + 1

def squares():
    for i in integers():
        yield i * i

def take(n, seq):
    """Returns first n values from the given sequence."""
    seq = iter(seq)
    result = []
    try:
        for i in range(n):
            result.append(seq.next())
    except StopIteration:
        pass
    return result

print take(5, squares()) # prints [1, 4, 9, 16, 25]



print "-"*50
print "Check difference between range and  xrange"

import time
now = time.time()
ll = xrange(500000)
before = time.time()-now
print "time taken using xrange is ", before 
now = time.time()
mm = range(500000)
after = time.time()-now
print "time taken using range is ", after

time.sleep(1)
print "THATS HUGE---in terms of no of times time taken for a list of 500000 integers is-->", int(after/before) 


print "-"*50
print "Pythagorean triplets using Generators"
print "-"*50


pyt = ((x, y, z) for z in integers() for y in xrange(1, z) for x in range(1, y) if x*x + y*y == z*z)
print take(10, pyt)


