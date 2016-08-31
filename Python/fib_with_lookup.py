

def memoize(f):
    cache = {}
    return lambda *args: cache[args] if args in cache else cache.update({args: f(*args)}) or cache[args]

@memoize
def fib2(n):
    return n if n<2 else fib2(n-1) + fib2(n-2)


def fib(n, lookup):
    if n == 0 or n == 1:
		lookup[n] = n
    if lookup[n] == None:
		lookup[n] = fib(n-1, lookup) + fib(n-2, lookup)
    return lookup[n]


def fib_recursive(n):
    if n == 0 or n == 1:
		return n
    else:
        return fib_recursive(n-1) + fib_recursive(n-2)

# public Collection<Triple> byBetterWhileLoop() {
#     Collection<Triple> result = new ArrayList<Triple>(limit);
#     for (int x = 1; x < limit; ++x) {
#         int xx = x * x;
#         int y = x + 1;
#         int z = y + 1;
#         while (z <= limit) {
#             int zz = xx + y * y;
#             while (z * z < zz) {++z;}
#             if (z * z == zz && z <= limit) {
#                 result.add(new Triple(x, y, z));
#             }
#             ++y;
#         }
#     }
#     return result;
# }


def find_triplets(n):
    '''
    Pythagoras triplets where x*x + y*y == z*z
    '''
    triplets = []
    for x in xrange(1, n):
        xx = x*x
        y = x + 1
        z = y + 1
        while z <= n:
            zz = xx+y*y
            while zz > z*z:
                z += 1
            if z*z == xx + y*y:
                triplets.append((x,y,z))
            y += 1
    return triplets
                        
    

def main():
    import time
#     lookup = [None]*(101)
    now = time.time()
    print find_triplets(10)
#   print fib(30, lookup)
#   print fib2(30)
    print "time taken using DP is ", time.time()-now
    now = time.time()
    #print fib_recursive(30)
    #print "time taken using recursive is ",time.time()-now



if __name__=='__main__':
	main()
