from heapq import *


class Meeting:
  def __init__(self, start, end):
    self.start = start
    self.end = end

  def __lt__(self, other):
      return self.end < other.end


def min_meeting_rooms(meetings):
  # TODO: Write your code here
  meetings.sort(key=lambda x : x.start)
  minRooms = 0
  minHeap = []


  for meeting in meetings:
        #remove all the meeting that have ended
    while len(minHeap) > 0 and meeting.start >= minHeap[0].end:
        heappop(minHeap)

    #add the current meeting into the heap
    heappush(minHeap, meeting)
    #all the active meetings are in the min_heap, so we need room for all
    minRooms = max(minRooms, len(minHeap))
  return minRooms



  return -1


def main():
  print("Minimum meeting rooms required: " + str(min_meeting_rooms(
    [Meeting(4, 5), Meeting(2, 3), Meeting(2, 4), Meeting(3, 5)])))
  print("Minimum meeting rooms required: " +
        str(min_meeting_rooms([Meeting(1, 4), Meeting(2, 5), Meeting(7, 9)])))
  print("Minimum meeting rooms required: " +
        str(min_meeting_rooms([Meeting(6, 7), Meeting(2, 4), Meeting(8, 12)])))
  print("Minimum meeting rooms required: " +
        str(min_meeting_rooms([Meeting(1, 4), Meeting(2, 3), Meeting(3, 6)])))
  print("Minimum meeting rooms required: " + str(min_meeting_rooms(
    [Meeting(4, 5), Meeting(2, 3), Meeting(2, 4), Meeting(3, 5)])))


main()
