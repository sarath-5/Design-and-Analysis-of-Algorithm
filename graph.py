import random
import time
import matplotlib.pyplot as plt

def selectionSort(array):
   size=len(array)
   for step in range(size):
     min_idx=step
     for i in range(step + 1,size):
       if array[i]<array[min_idx]:
        min_idx=i
     (array[step],array[min_idx])=(array[min_idx],array[step])
list1=[random.randint(0,1000) for i in range(20000)]
times=[]
input_sizes=[]
for x in range(0,10000,150):
    start_time=time.time()
    # print("1")
    lst=selectionSort(list1[:x])
    print(x)

    total_time=time.time()-start_time
    times.append(total_time)
    input_sizes.append(x)

plt.plot(input_sizes,times)
plt.ylabel('time')
plt.xlabel('input size')

plt.show()