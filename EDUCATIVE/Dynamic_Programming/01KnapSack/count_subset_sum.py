def count_subsets(num, sum):
    return count_subset_sum_recursive(num, sum, 0)

def count_subset_sum_recursive(num, sum, currentIndex):
    if sum == 0:
        return 1

    n = len(num)
    if n == 0 or currentIndex >= n:
        return 0

    sum1 = 0
    #include the item into the list
    if num[currentIndex] <= sum:
        sum1 = count_subset_sum_recursive(num, sum - num[currentIndex], currentIndex + 1)

    sum2 = count_subset_sum_recursive(num, sum, currentIndex + 1)

    return sum1 + sum2

def main():
  print("Total number of subsets " + str(count_subsets([1, 1, 2, 3], 4)))
  print("Total number of subsets: " + str(count_subsets([1, 2, 7, 1, 5], 9)))


main()