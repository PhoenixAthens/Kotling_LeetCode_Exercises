class Minimum_Time_To_Color_The_Rope {
    fun minCost(colors:String, neededTime:Array<Int>):Int{
        var counter=0
        var time=0
        while(counter<colors.length-1){
            if(colors[counter]==colors[counter+1]){
                if(neededTime[counter]<neededTime[counter+1]){
                    time+=neededTime[counter]
                }else if(neededTime[counter+1]<neededTime[counter]){
                    time+=neededTime[counter+1]
                    var temp=neededTime[counter]
                    neededTime[counter]=neededTime[counter+1]
                    neededTime[counter+1]=temp
                }else
                    time+=neededTime[counter]
            }
            counter++
        }
        return time
    }
}