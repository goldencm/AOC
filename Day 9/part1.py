#python is whack sometimes
def populateInitial(array, pos):
    num = array[pos]
    pos += 1
    sumArray = []
    while pos < 25:
        sumArray.append(num + array[pos])
        pos += 1
    return {num : sumArray} 

def contains(two_D_Array, num):
    for array_values in two_D_Array:
        array = array_values.values()
        for x in array:
            for y in x:
                if y == num:
                    return True;
    return False

#lets think
#take the next number
#we dont need the data so we can del as we go
def populateNext(two_D_Array, nextNumber):
        new_two_D_Array = []
        #lets just create a new one
        for my_dict in two_D_Array:
            list_of_sums = list(my_dict.values())[0]
            
            key = [int(k) for k in my_dict.keys()]
            list_of_sums.append(key[0] + nextNumber)
            
            new_two_D_Array.append({key[0] : list_of_sums})
        new_two_D_Array.append({nextNumber : []})
        return new_two_D_Array

if __name__ == "__main__":
    f = open("data.txt", "r")
    Lines = f.readlines()
    data = []
    two_D_Array = []
    i = 0
    while i < 25:
        line = Lines[i]
        data.append(int(line.strip()))
        i += 1

    indexer = 0 
    for num in data:
        two_D_Array.append(populateInitial(data, indexer))
        indexer += 1

    while i < len(Lines) and contains(two_D_Array, int(Lines[i])):
        nextNumber = int(Lines[i])
        del two_D_Array[0]
        two_D_Array = populateNext(two_D_Array, int(Lines[i]))
        i += 1
    print(Lines[i])

    

