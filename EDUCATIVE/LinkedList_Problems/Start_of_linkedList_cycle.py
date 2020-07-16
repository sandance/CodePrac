class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def calculate_cycle_length(slow):
        cycle_length  = 0
        current = slow

        while True:
            cycle_length += 1
            if slow == current:
                break
        return cycle_length


    def find_cycle_head(head):
        cycle_length = 0

        slow, fast = head, head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                cycle_length = calculate_cycle_length(slow)
                break
            return find_start(head, cycle_length)

    def fast_start(head, cycle_length):
        pointer1 = head
        pointer2 = head

        while cycle_length > 0:
            pointer2 = pointer2.next
            cycle_length -= 1

        while pointer1 != pointer2:
            pointer1 = pointer1.next
            pointer2 = pointer2.next

        return pointer1



