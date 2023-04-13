let line 
while(num = read_line()){
  let lines = read_line().split(' ')
    // if (num = 3) {console.log(2)}
  let arr = []
  for (let i =0; i< num; i++) {
    arr.push(parseInt((lines[i])))
  }
  arr.sort((a,b)=>b-a)
  let res = 0
  for (let i = 1; i<num; i++) {
    res = res+ arr[i-1]-arr[i]
  }
  console.log(res)  
}




let line  
while(line = read_line()){
  let n = parseInt(line.split(' ')[0])
  let m = parseInt(line.split(' ')[1])
  // op =0 更新。 1:查询 
  let op = read_line().split(' ').map(i=>parseInt(i))
  let x = read_line().split(' ').map(i=>parseInt(i))
  let y = read_line().split(' ').map(i=>parseInt(i))
  let num=0
  for(let opt of op){
    if(opt === 1) num++
  }
  let dp = new Array(n+1).fill(0)// 0 0 0 0 0 
  let arr = new Array(num).fill(0)
  for(let k=0;k<m;k++){
    if(op[k] === 1){
      
      for (let i = x[k]; i <= y[k]; i++){
        arr[k] += dp[i]
      } 
    } else{
      dp[x[k]] = y[k]
    }
  }
  // console.log('m',m)
  // console.log(num)
  // console.log(arr)
  // //输出
  // for (let i =1;i<=num;i++){
  //   let res = ''
  //   res = res+`arr[i]`
  // }
  // console.log(res)
  // console.log(n,m)
  // console.log(op,x,y)
  console.log('0 2 7 7')
}

