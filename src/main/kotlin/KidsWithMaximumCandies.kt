import kotlin.collections.List;
//Runtime: 195ms beats 22%, Memory: 36.2MB beats 6.2MB
class KidsWithMaximumCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val arrResult= ArrayList<Boolean>(candies.size)
        val maxVal = candies.max()!!
        for( value in candies ){
            if((value+extraCandies)>=maxVal)arrResult.add(true)
            else arrResult.add(false);
        }
        return arrResult
    }
}