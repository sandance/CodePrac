"""

def countdown(n):
    print ("Counting down from %d" % n)
    while n > 0:
        yield n
        n -= 1
    return

c = countdown(10)
while True:
    print c.next()

#yield could be also used at right side of assignment operator
"""
def receiver():
    print ("Ready to receive")
    while True:
        n = (yield)
        print ("Got %s" % n)

r = receiver()
for i in range(1, 10):
    print r.send(int(i))

