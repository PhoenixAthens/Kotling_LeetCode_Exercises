class LongestZigZagPath {
    //Runtime: 437ms beats 17.61%, Memory: 103.2MB beats 5.28%
    class TreeNode(var `val`: Int){
        var left:TreeNode ? = null
        var right:TreeNode ? = null
    }
    fun longestZigZag(root: TreeNode?): Int {
        val max:Array<Int> = Array<Int>(1){0}
        if(root!=null) {
            dfs(root, true, 0, max)
            dfs(root, false, 0, max)
        }
        return max[0]
    }
    fun dfs(root:TreeNode,goLeft:Boolean,count:Int,max:Array<Int>):Unit{
        max[0] = max[0].coerceAtLeast(count)
        if(goLeft){
            root.left?.let { dfs(it,false,count+1,max) }
            root.right?.let{dfs(it,true,1,max)}
        }else{
            root.right?.let{dfs(it,true,count+1,max)}
            root.left?.let{dfs(it,false,1,max)}
        }
    }
}