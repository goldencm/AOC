def rotate90(wayX, wayY, action):
    if action == "L":
        X = wayY * -1
        return [X, wayX]

    Y = wayX * -1
    return [wayY, Y]
 
    
def rotate180(wayX, wayY, action):
    cord = rotate90(wayX, wayY, action)
    return rotate90(cord[0], cord[1], action)
    

def rotate270(wayX, wayY, action):
    cord = rotate90(wayX, wayY, action)
    cord = rotate90(cord[0], cord[1], action)
    return rotate90(cord[0], cord[1], action)

if __name__ == '__main__':
    f = open("data.txt", "r")
    Lines = f.readlines()
    data = []
    for line in Lines:
        data.append(line.strip())
    direction = "NE"
    xPosition = 0
    yPosition = 0
    wayX = 10
    wayY = 1
    directions = ['NW', 'NE', 'SE', 'SW']
    directionChange = {1 : rotate90, 2 : rotate180, 3 : rotate270}
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
            newCoord = directionChange[change](wayX, wayY, action)
            wayX = newCoord[0]
            wayY = newCoord[1]


        elif action == "R":
            change = int(value) / 90
            index = directions.index(direction) + int(change)
            if index > 3:
                index = index - 4
            direction = directions[index]
            newCoord = directionChange[change](wayX, wayY, action)
            wayX = newCoord[0]
            wayY = newCoord[1]


        
        elif action == "E":
            wayX += value
        elif action == "W":
            wayX -= value
        elif action == "S":
            wayY -= value
        elif action == "N":
            wayY += value
        else: #is F
            
            xPosition += value * wayX
            yPosition += value * wayY
            print("FowardX", value, "*", wayX, "=", xPosition)
            print("FowardY", value, "*", wayY, "=", yPosition)
        print("Dir", direction, "wayX", wayX, "wayY", wayY)
    if(xPosition < 0):
        xPosition *= -1
    if(yPosition < 0):
        yPosition *= -1
    print(xPosition + yPosition)
