alphabet_list = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ'];
word = input()

time = 0
for unit in alphabet_list:
    for i in unit:
        for x in word :
            if i == x :
                time += alphabet_list.index(unit) + 3

print(time)