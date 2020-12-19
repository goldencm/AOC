



if __name__ == '__main__':
    f = open("data.txt", "r")
    Lines = f.readlines()
    data = []
    data.append(0)
    for line in Lines:
        data.append(int(line.strip()))

    data.sort()
    oneDif = 0
    threeDif = 0

    ind = 1

    while ind < len(data):
        if (data[ind] - data[ind - 1] == 1):
            print("One dif: ", data[ind], data[ind - 1])
            oneDif += 1
        elif (data[ind] - data[ind - 1] == 3):
            print("Three dif: ", data[ind], data[ind - 1])
            threeDif += 1

        ind += 1
    
    print(oneDif * (threeDif + 1))
    print(data)