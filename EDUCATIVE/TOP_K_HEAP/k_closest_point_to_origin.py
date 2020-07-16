from heapq import *

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def print_point(self):
        print ("[" + str(self.x) +", " + str(self.y) + "]")

    def distance_from_origin(self):
        #ignoring sqrt to calculate
        return (self.x * self.x) + (self.y * self.y)

    def __lt__(self, other):
        return self.distance_from_origin() > other.distance_from_origin()

    
    
    
def find_closest_points(points, k):
    maxHeap = []

    #first put k elements into the heap
    for i in range(k):
        heappush(maxHeap, points[i])

    for i in range(k, len(points)):
        if points[i].distance_from_origin() < maxHeap[0].distance_from_origin():
            heappop(maxHeap)
            heappush(maxHeap, points[i])

    return list(maxHeap)


def main():
    result = find_closest_points([Point(1,3), Point(3,4)], 1)
    print ("Here are K points close to origin")
    for point in result:
        point.print_point()
