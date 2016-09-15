'''
Write a program that takes one or more filenames as 
arguments and prints all the lines which are longer than 40 characters.
'''

def foo(filenames):
    for filename in filenames:
        with open(filename) as f:
            line = f.readline()
            yield line
            



class StaticTest():
    class_member = "ujjwal"
    
    def __init__(self):
        '''
        This is the contructor
        '''
        self.name = "Singh"
        
    def noo(self):
        '''
        this is an instance method
        
        '''
        print "in instance method"
        
    @staticmethod
    def foo():
        print "this is a static method can be called on the class"
        print "this can not acccess instantce object too"
        
    @classmethod
    def goo(cls):
        print "this can access only class members ", cls.class_member
        print "this can not access the instance member throw error"
        
        

print 'Static method can be called on class'
StaticTest.foo()


s = StaticTest()
print 'static method can be called on instance too'
s.foo()

print('instance methods can be callled from only the instances')

s.noo()

print 'Class methods '
s.goo()

StaticTest.goo()


