class Solution(object):
    def wordPattern(self, pattern, str):
        """
        >>> pattern="abba"
        >>> str="dog cat cat dog"
        >>> str = str.split()
        >>> str
        ['dog', 'cat', 'cat', 'dog']
        >>> a = zip(pattern, str)
        >>> a
        [('a', 'dog'), ('b', 'cat'), ('b', 'cat'), ('a', 'dog')]
        >>> set(a)
        set([('b', 'cat'), ('a', 'dog')])
        >>> set(str)
        set(['dog', 'cat'])
        >>> set(pattern)
        set(['a', 'b'])
        """
        str = str.split()
        a = zip(pattern, str)
        print a
        return len(pattern) == len(str) and 
        len(set(a)) == len(set(pattern)) == len(set(str))


