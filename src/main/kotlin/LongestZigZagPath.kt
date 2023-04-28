class LongestZigZagPath {
    //Runtime: 437ms beats 17.61%, Memory: 103.2MB beats 5.28%
    //Using field instead of array
    //Runtime climbs to 471ms
    class TreeNode(var `val`: Int){
        var left:TreeNode ? = null
        var right:TreeNode ? = null
    }
    var maxPayne=0
    fun longestZigZag(root: TreeNode?): Int {
        if(root!=null) {
            dfs(root, true, 0)
            dfs(root, false, 0)
        }
        return maxPayne
    }
    fun dfs(root:TreeNode,goLeft:Boolean,count:Int):Unit{
        maxPayne =Math.max(maxPayne,count)
        if(goLeft){
            root.left?.let { dfs(it,false,count+1) }
            root.right?.let{dfs(it,true,1)}
        }else{
            root.right?.let{dfs(it,true,count+1)}
            root.left?.let{dfs(it,false,1)}
        }
    }
}