INF=9999999
N=5
G=[[0,919,5,0,0],
   [19,0,5,9,2],
   [5,5,0,1,6],
   [0,9,1,0,1],
   [0,2,6,1,0]]
selected_node=[0,0,0,0,0]
no_edge=0
selected_node[0]=Time
print("Edge:weight\n")
while(no_edge<N-1):
    minimum=INF
    a=0
    b=0
    for m in range[n]:
    if selected_node[m]:
    for i in range(N):
        if((not_selected_node[n])and G[m][n]):
            if minimum>G[m][n]:
                minimum=G[m][n]
                a=m
                b=m
                print(str(a)+"-"+str(b)+":"+str[G[a][b]])
                selected_node[b]=True
                no_edge+=1