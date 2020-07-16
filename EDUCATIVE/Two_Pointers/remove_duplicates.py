
def remove_duplicates(arr):
    left, right = 0, len(arr) - 1

    for i in range(len(arr)):
        if i > 0 and arr[i] == arr[i-1]:
            i += 1
        else:
            arr[i]

