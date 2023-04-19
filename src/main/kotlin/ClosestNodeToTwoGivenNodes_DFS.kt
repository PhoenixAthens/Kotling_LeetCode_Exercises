class ClosestNodeToTwoGivenNodes_DFS {
    //Runtime: 661ms beats 50%, Memory: 116MB beats 33.33%
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val dst1 = Array<Int>(edges.size){-27}
        val dst2 = Array<Int>(edges.size){-27}
        dst1[node1] = 0
        dst2[node2] = 0
        val vst1 = Array<Boolean>(edges.size){false}
        val vst2 = Array<Boolean>(edges.size){false}
        dfs(edges,dst1,vst1,node1)
        dfs(edges,dst2,vst2,node2)
        var curResult =-1
        var maxDist = 2_000_000_000
        for(i in edges.indices){
            if(dst1[i]==-27 || dst2[i]==-27)continue
            var tempDist = dst1[i].coerceAtLeast(dst2[i])
            if(tempDist<maxDist){
                maxDist = tempDist
                curResult = i
            }
        }
        return curResult
    }
    fun dfs(edges: IntArray, dist: Array<Int>, visit: Array<Boolean>, node:Int){
        if(!visit[node]){
            visit[node] = true
            var neighbor = edges[node]
            if(neighbor!=-1 && !visit[neighbor]){
                dist[neighbor]=1+dist[node]
                dfs(edges,dist,visit,neighbor)
            }
        }
    }
}