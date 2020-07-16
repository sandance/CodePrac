
enable_tracking = True

if enable_tracking :
    debug_log = open("debug.log", "w")

def trace(func):
    if enable_tracking:
        def callf(*args, **kwargs):
            debug_log.write("Calling %s: %s, %s\n" % (func.__name__ , args, kwargs))
            r = func(*args, **kwargs)
            debug_log.write("%s returned %s\n" % (func.__name__, r))
            return r
        return callf
    else:
        return func


@trace
def square(x):
    return x * x


print square(5)
print square(2)



