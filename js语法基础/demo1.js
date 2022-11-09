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
