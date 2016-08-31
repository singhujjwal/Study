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

    