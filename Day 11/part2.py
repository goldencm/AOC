def getSeat(data, x, y):
    return data[y][x]

def getRightNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and x + 1 < len(data[0]):
        return getRightNearestSeat(data, x + 1, y)
    return getSeat(data, x, y)

def getLeftNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and x - 1 >= 0:
        return getLeftNearestSeat(data, x - 1, y)
    return getSeat(data, x, y)

def getUpNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and y + 1 < len(data):
        return getUpNearestSeat(data, x, y + 1)
    return getSeat(data, x, y)

def getDownNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and y - 1 >= 0:
        return getDownNearestSeat(data, x, y - 1)
    return getSeat(data, x, y)

def getDownRightNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and y - 1 >= 0 and x + 1 < len(data[0]):
        return getDownRightNearestSeat(data, x + 1, y - 1)
    return getSeat(data, x, y)

def getDownLeftNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and y - 1 >= 0 and x - 1 >= 0:
        return getDownLeftNearestSeat(data, x - 1, y - 1)
    return getSeat(data, x, y)

def getUpRightNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and y + 1 < len(data) and x + 1 < len(data[0]):
        return getUpRightNearestSeat(data, x + 1, y + 1)
    return getSeat(data, x, y)

def getUpLeftNearestSeat(data, x, y):
    if (getSeat(data, x, y) == '.') and y + 1 < len(data) and x - 1 >= 0:
        return getUpLeftNearestSeat(data, x - 1, y + 1)
    return getSeat(data, x, y)    


def adjacentSeatsEmpty(data, x, y):
    limit = [len(data[0]), len(data)]
    match = True
    symbol = '#'
    if x + 1 < limit[0]:
        match = match and symbol != getRightNearestSeat(data, x + 1, y)
    if x - 1 >= 0:
        match = match and symbol != getLeftNearestSeat(data, x - 1, y)
    if y + 1 < limit[1]:
        match = match and symbol != getUpNearestSeat(data, x, y + 1)
    if y - 1 >= 0:
        match = match and symbol != getDownNearestSeat(data, x, y - 1)
    if y - 1 >= 0 and x - 1 >= 0:
        match = match and symbol != getDownLeftNearestSeat(data, x - 1, y - 1)
    if y - 1 >= 0 and x + 1 < limit[0]:
        match = match and symbol != getDownRightNearestSeat(data, x + 1, y - 1)
    if y + 1 < limit[1] and x - 1 >= 0:
        match = match and symbol != getUpLeftNearestSeat(data, x - 1, y + 1) 
    if y + 1 < limit[1] and x + 1 < limit[0]:
        match = match and symbol != getUpRightNearestSeat(data, x + 1, y + 1)
    return match

def adjacentSeatsOccupied(data, x, y):
    limit = [len(data[0]), len(data)]
    seatcount = 0
    symbol = '#'
    if x + 1 < limit[0] and symbol == getRightNearestSeat(data, x + 1, y):
        seatcount += 1
    if x - 1 >= 0 and symbol == getLeftNearestSeat(data, x - 1, y):
        seatcount += 1
    if y + 1 < limit[1] and symbol == getUpNearestSeat(data, x, y + 1):
        seatcount += 1
    if y - 1 >= 0 and symbol == getDownNearestSeat(data, x, y - 1):
        seatcount += 1
    if y - 1 >= 0 and x - 1 >= 0 and symbol == getDownLeftNearestSeat(data, x - 1, y - 1):
        seatcount += 1
    if y - 1 >= 0 and x + 1 < limit[0] and symbol == getDownRightNearestSeat(data, x + 1, y - 1):
        seatcount += 1 
    if y + 1 < limit[1] and x - 1 >= 0 and symbol == getUpLeftNearestSeat(data, x - 1, y + 1):
        seatcount += 1 
    if y + 1 < limit[1] and x + 1 < limit[0] and symbol == getUpRightNearestSeat(data, x + 1, y + 1):
        seatcount += 1 

    return seatcount > 4


def adjacentSeats(data, symbol, x, y):
    
    if symbol == 'L':
        return adjacentSeatsEmpty(data, x, y)
    else:
        return adjacentSeatsOccupied(data, x, y)
    
    

def printPlot(data):
    for x in range(len(data)):
        print(data[x])
    print()

if __name__ == '__main__':
    f = open("data.txt", "r")
    Lines = f.readlines()
    oldDataPlot = []
    for line in Lines:
        oldDataPlot.append(line.strip())

                  #x  y
    coordinates = [0, 0]
    #       x max_length   y max_length
    
    changed = True
    newDataPlot = oldDataPlot.copy()

    while changed:
        #printPlot(newDataPlot)
        oldDataPlot = newDataPlot.copy()
        changed = False
        for y in range(0, len(oldDataPlot)):
            for x in range(0, len(oldDataPlot[y])):
                element = getSeat(oldDataPlot, x, y)
                if element != '.' and adjacentSeats(oldDataPlot, element, x, y):
                    changed = True
                    row = list(newDataPlot[y])
                    if element == '#':
                        row[x] = 'L'
                    else:
                        row[x] = '#'
                    newDataPlot[y] = "".join(row)


    count = 0

    for row in newDataPlot:
        for element in row:
            if element == '#':
                count += 1

    print(count)

    
    