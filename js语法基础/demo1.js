var a = [];
for (var i = 0; i < 10; i++) {
  a[i] = function () {
    console.log(i);
  };
}
a[6](); // 10

// dp1问题在一 fill里面只有一个new 引用的是同一个（同一个内存地址）
let s="abc"

let dp1=new Array(s.length).fill(new Array(s.length).fill(false));
dp1[1][1]=true
console.log("dp1",dp1)

let dp2 = Array(s.length).fill().map(()=>Array(s.length).fill(false));
dp2[1][1]=true
console.log('dp2',dp2)

let dp3 = Array.from(Array(s.length), () => Array(s.length).fill(false));
dp3[1][1]=true
console.log('dp3',dp3)

// // 深拷贝
// const originArray = [1,2,3,4,5]; 
// const cloneArray = originArray;
// console.log(originArray===cloneArray)

// const cloneArray2 = JSON.parse(JSON.stringify(originArray))
// console.log(originArray===cloneArray2)

let arr=[1,2,3]
let res=[]
res.push(arr.shift())
console.log(res)

let str1="23"
let str2="45"
let str3="67"
let res1 = []
let path = []
path.push(str1[0])
path.push(str2[1])
console.log(path)
let temp=path.join("")
console.log(temp)
res1.push(temp)
console.log(res1)
// console.log(str.length)


var arr2 = Array.from(new Array(3),()=>new Array(2).fill(0));
arr2[2][1]=1
console.log("arr2:",arr2)
var arr3 = new Array(3).fill().map(()=>new Array(2).fill(0))
arr3[2][1]=1
console.log("arr3:",arr3)
