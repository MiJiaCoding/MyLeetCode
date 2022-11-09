var a = [];
for (var i = 0; i < 10; i++) {
  a[i] = function () {
    console.log(i);
  };
}
a[6](); // 10

let s="abc"
let dp=new Array(s.length).fill(new Array(s.length).fill(false))
console.log(dp)