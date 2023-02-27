word = input()
ans = 0

for i in range(len(word)):
    if word[i] != word[len(word)-1-i] :
        ans = 1
        print('0')
        break

if ans == 0 :
    print('1')