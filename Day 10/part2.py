
if __name__ == '__main__':
    f = open("data.txt", "r")
    Lines = f.readlines()
    data = []
    data.append(0)
    for line in Lines:
        data.append(int(line.strip()))

    data.sort()
    del data[0]
    print(data)
    adapters = [0]
    paths = [1]
    
    for element in data:
        num_branches = 0
        current_num_paths = 0
        for adapter in adapters:
            if element - adapter < 4:
                num_branches += 1
        paths.reverse()
        for x in range(num_branches)[::-1]:
            print("Adding", paths[x], "to", current_num_paths)
            print(x)
            current_num_paths += paths[x]
        paths.reverse()
        
        
        print("num_branches\t", num_branches)
        print("element\t\t", element)
        print("curr_num_path\t", current_num_paths)
        print("paths\t\t",paths)
        print("adapters\t",adapters)
        print()

        if len(paths) == 3:
            del paths[0]

        if len(adapters) == 3:
            del adapters[0]

        paths.append(current_num_paths)
        adapters.append(element)   

    print(paths[-1])