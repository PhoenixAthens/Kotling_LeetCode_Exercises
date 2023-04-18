//Date: 18th April 2023
class MergeStringAlternately {
    //Runtime: 136ms beats 96.55%, Memory: 34.4MB beats 72.41%
    fun mergeAlternately(word1: String, word2: String): String {
        val collectAlter= StringBuilder()
        val len1=word1.length
        val len2=word2.length
        if(len1>len2){
            for(i in 0 until len2){
                collectAlter.append(word1[i])
                collectAlter.append(word2[i])
            }
            for(i in len2 until len1){
                collectAlter.append(word1[i])
            }
        }else if(len2>len1){
            for(i in 0 until len1){
                collectAlter.append(word1[i])
                collectAlter.append(word2[i])
            }
            for(i in len1 until len2){
                collectAlter.append(word2[i])
            }
        }else{
            for(i in 0 until len1){
                collectAlter.append(word1[i])
                collectAlter.append(word2[i])
            }
        }
        return collectAlter.toString()
    }
}