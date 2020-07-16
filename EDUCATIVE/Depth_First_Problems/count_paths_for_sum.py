class TreeNode:
  def __init__(self, val, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right


def count_paths(root, S):
  # TODO: Write your code here
  return count_paths_recursive(root, S, [])

def count_paths_recursive(currentNode, S, currentPath):
  if currentNode is None:
    return 0

  currentPath.append(currentNode.val)

  pathCount, pathSum = 0 ,0

  #find the sum of all sub-paths in the current path list
  for i in range(len(currentPath) - 1, -1, -1):
    pathSum += currentPath[i]

    if pathSum == S:
      pathCount += 1

  pathCount += count_paths_recursive(currentNode.left, S, currentPath)
  pathCount += count_paths_recursive(currentNode.right, S, currentPath)

  del currentPath[-1]

  return pathCount




def main():
  root = TreeNode(12)
  root.left = TreeNode(7)
  root.right = TreeNode(1)
  root.left.left = TreeNode(4)
  root.right.left = TreeNode(10)
  root.right.right = TreeNode(5)
  print("Tree has paths: " + str(count_paths(root, 11)))


main()
