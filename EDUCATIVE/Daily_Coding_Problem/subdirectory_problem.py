def build_fs(input):
    """
    The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
    """

    fs = {}
    files = input.split('\n')

    current_path = []

    for f in files:
        indentation = 0
        while '\t' in f[:2]:
            indentation += 1
            f = f[1:]

        current_node = fs
        for subdir in current_path[:indentation]:
            current_node = current_node[subdir]
        #FILES 
        if '.' in f:
            current_node[f] = True
        else:
            current_node[f] = {}
        
        current_path = current_path[:indentation]
        print("current node {} and current_path {}".format(current_node, current_path))
        current_path.append(f)
    
    return fs


build_fs('dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext')

