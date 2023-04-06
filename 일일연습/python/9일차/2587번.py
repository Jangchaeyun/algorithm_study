numbers = []
for index in range(5):
   number = int(input())
   numbers.append(number)
average = int(sum(numbers)/5)
median = sorted(numbers)[2]

print(average)
print(median)