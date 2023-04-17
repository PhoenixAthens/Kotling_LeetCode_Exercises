//:< Not working!!
class ClosestNodeToTwoGivenNodes {
    fun bfs(dist:Array<Int>,edges:IntArray,node:Int){
        var boolArray = Array(edges.size){false}
        var presentNode = node
        dist[node] = 0
        while(node!=-909){
            if(boolArray[node]){
                continue
            }else{
                boolArray[node]=true;
                val neighbor =edges[node]
                if(neighbor!=-1 && !boolArray[neighbor]){
                    dist[neighbor]=1+dist[presentNode]
                    presentNode=neighbor
                }else{
                    presentNode = -909
                }
            }
        }
    }

    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        var dist1: Array<Int> = Array(edges.size){-27}
        var dist2: Array<Int> = Array(edges.size){-27}
        bfs(dist1,edges,node1)
        bfs(dist2,edges,node2)
        var resultNode=-1
        var maxTillNow=2_000_000_000
        for(i in 0 until(edges.size)){
            if(dist1[i]==-27 || dist2[i]==-27){
                continue
            }else{
                val tempMax = dist1[i].coerceAtLeast(dist2[i])
                if(tempMax<maxTillNow){
                    resultNode=i
                    maxTillNow = tempMax
                }
            }
        }
        return resultNode
    }


}