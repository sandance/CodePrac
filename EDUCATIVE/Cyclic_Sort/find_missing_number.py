def find_missing_number(nums):
    i = 0
    while i < len(nums):
        j = nums[i]
        if nums[i] < n  and nums[i] != nums[j]:
            nums[j], nums[i] = nums[i] , nums[j]
        else:
            i += 1
    return nums


def main():
    print(find_missing_number([4, 0, 3, 1]))
    print(find_missing_number([8, 3, 5, 2, 4, 6, 0, 1]))


main()