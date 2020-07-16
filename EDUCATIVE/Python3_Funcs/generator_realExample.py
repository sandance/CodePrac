import os
import fnmatch

def find_files(topdir, pattern):
    for path, dirname, filelist in os.walk(topdir):
        for name in filelist:
            if fnmatch.fnmatch(name, pattern):
                yield os.path.join(path, name)


import gzip, bz2

def opener(filenames):
    for name in filenames:
        if name.endswith(".gz"): f = gzip.open(name)

