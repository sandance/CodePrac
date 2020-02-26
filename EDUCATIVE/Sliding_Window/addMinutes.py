

def addMinutes(current_time, add_minutes=0):
    """
        
    """
    current_time, time_format = current_time.strip().split()
    hour,minute=map(int,current_time.split(':'))
    
    assert (hour <= 12 and hour >= 0), "Enter 12 hour format"
    assert (minute <= 60 and minute >= 0) ,"Minutes entry not valid"
    assert (add_minutes >= 0 and add_minutes <= 3600 and type(add_minutes) == int), "add_minutes has to be 0<=add_minutes<3600 and integer"

    #convert time to 24 hr format
    carry = 12 if time_format == "PM" else 0

    total_time = (hour + carry) * 60 + minute + int(add_minutes) 
    time_format = "PM" if total_time >= 12 * 60  and total_time < 24 * 60 else "AM"

    output_hr = int(total_time / 60)

    
    output_hr, output_min = output_hr % 12 if output_hr > 12 else output_hr, total_time % 60
    result="{0}:{1} {2}".format(output_hr, output_min, time_format) 
    return result


def __name__='__main__':
    print addMinutes("1:59 AM", 60)
    print addMinutes("9:13 PM", 600)
    print addMinutes("11:13 PM", 60)
    #print addMinutes("14:13 PM", 60)
    print addMinutes("00:01 AM", 60)



