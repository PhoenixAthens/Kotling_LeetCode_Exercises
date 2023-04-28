class LastStoneWeight {
    //Runtime: 143ms beats 71.57%, Memory: 34.4MB beats 38.73%
    fun lastStoneWeight(stones: IntArray): Int {
        var len:Int=stones.size
        while(len>1){
            var max1:Int
            var max2:Int
            var indexMax1:Int
            var indexMax2:Int
            if(stones[0]>=stones[1]){
                max2=stones[0]
                indexMax2=0
                max1=stones[1]
                indexMax1=1
            }else{
                max1=stones[0]
                indexMax1=0
                max2=stones[1]
                indexMax2=1
            }
            for( i in 2 until stones.size){
                if(stones[i]==-234)continue
                if(stones[i]>=max2){
                    max1=max2
                    indexMax1=indexMax2
                    max2=stones[i]
                    indexMax2=i
                }else if(stones[i]>max1){
                    max1 = stones[i]
                    indexMax1 = i
                }
            }
            if(max1==max2){
                stones[indexMax1]=-234
                stones[indexMax2]=-234
                len-=2
            }else{
                stones[indexMax1]=-234
                stones[indexMax2]=max2-max1
                len-=1
            }
        }
        for(i in stones.indices){
            if(stones[i]!=-234)return stones[i]
        }
        return 0
    }
}