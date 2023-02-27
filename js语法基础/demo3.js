// 46.全排列
const qpl = function(arr) {
    let res = []
    let used = []
    let path = []
    dfs(arr,arr.length,used,res,path)
    return res
}
const dfs = function(arr,k,used,res,path){
    if(path.length===k) {
        res.push(Array.from(path))
        return 
    }
    for (let i = 0 ; i<k ; i++) {
        if (used[i]) continue
        // 未使使用,加入path
        used[i]=true
        path.push(arr[i])
        dfs(arr,k,used,res,path)
        path.pop()
        used[i]=false
    }
}

const arr = [1,2,3]
const res = qpl(arr)
console.log(res)
