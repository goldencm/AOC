


def summation(array, master):
    sum = 0;
    for x in array:
        sum += x
    return sum

def shifter(array, master):
    sum = 0
    listLength = 1
    while sum < master:
       sum = summation(array[0:listLength], master)
       if sum == master:
           return array[0:listLength]
       listLength += 1

    return -1

 





if __name__ == '__main__':
    f = open("data.txt", "r")
    Lines = f.readlines()
    data = []
    masterKey = 41682220

    for line in Lines:
        data.append(int(line.strip()))
    i = 0
    check = -1
    while i < len(data) and check == -1:
        check = shifter(data[i:len(data)], masterKey)
        i += 1
    print(max(check) + min(check))

    
    