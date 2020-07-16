class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def find_path_sequence(currentNode, sequence, index):
    if currentNode is None:
        return False

    seqLen = len(sequence)
    if currentNode.val != sequence[index] and index >= seqLen:
        return False

    #if current node is a leaf and it is the end of the sequence , we found a path
    if currentNode.left is None and currentNode.right is None and index == seqLen - 1:
        return True

    return find_path_sequence(currentNode.left, sequence, index + 1) or \
            find_path_sequence(currentNode.right, sequence, index + 1)





def find_path(root, sequence):
    if root is None:
        return False
    return find_path_sequence(root, sequence, 0)


def main():
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(5)

    print("Tree has path sequence: " + str(find_path(root, [1, 0, 7])))
    print("Tree has path sequence: " + str(find_path(root, [1, 1, 6])))


main()
