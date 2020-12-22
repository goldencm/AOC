if __name__ == '__main__':
    f = open("data.txt", "r")
    Lines = f.readlines()
    data = []
    for line in Lines:
        data.append(line.strip())
    direction = "E"
    xPosition = 0
    yPosition = 0
    directions = ['N', 'E', 'S', 'W']
    for order in data:
        action = order[0:1]
        value = int(order[1:len(order)])
        print(action, value)
        if action == "L":
            change = int(value) / 90
            index = directions.index(direction) - int(change)
            if index < 0:
                index += 4
            direction = directions[index]
        elif action == "R":
            change = int(value) / 90
            index = directions.index(direction) + int(change)
            if index > 3:
                index = index - 4
            direction = directions[index]


        
        elif action == "E":
            xPosition += value
        elif action == "W":
            xPosition -= value
        elif action == "S":
            yPosition -= value
        elif action == "N":
            yPosition += value
        else:
            if direction == "E":
                xPosition += value
            elif direction == "W":
                xPosition -= value
            elif direction == "S":
                yPosition -= value
            else:
                yPosition += value
    if(xPosition < 0):
        xPosition *= -1
    if(yPosition < 0):
        yPosition *= -1
    print(xPosition + yPosition)
