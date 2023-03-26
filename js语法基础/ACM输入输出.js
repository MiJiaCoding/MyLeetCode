// // let line = readline();
// // let nums = line.split(' ');
// // let res = 0;
// // let data = nums[0] *nums[1];
// // for(let i = 1 ; i <=data ; i++){
// //     if(i%nums[0]==0 && i%nums[1]==0) {
// //         res = i;
// //         break;
// //     }
// // }
// // console.log(res);

// let line = require("readline").createInterface({ input: process.stdin });
const rl = require("readline").createInterface({ input: process.stdin });
var iter = rl[Symbol.asyncIterator]();
const readline = async () => (await iter.next()).value;
void (async function () {
    const createMat = (n, m) => {
      let chooseList = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
      let result = new Array(n).fill(0).map(item=>new Array(m).fill(0))
      for (let j=0; j<m; j++) {
          for (let i=0; i<n; i++) {
              let temp = chooseList.shift();
              result[i][j] = temp;
              chooseList.push(temp);
          }
      }
      return result
    };
    while ((line = await readline())) {
      let tokens = line.split(" ");
      let n = parseInt(tokens[0]);
      let m = parseInt(tokens[1]);
      let result =  createMat(n,m)
      for (row of result) {
          console.log(row.join(" "));
      }
    }
  })();


// const readLine = require('readline');
//  let rl = readLine.createInterface({
//   input: process.stdin,
//   output: process.stdout,
//   prompt: '> 请输入'
//  })
//  // 调用
//  rl.prompt(); // 控制台结果显示：>请输入

// whatever 

