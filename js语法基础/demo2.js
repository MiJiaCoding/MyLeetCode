// // -------------- Set ---------------
// const set = new Set([1, 2, 3, 4, 4]);
// console.log([...set])


// // 去除字符串里面的重复字符
// let q1 = [...new Set('ababbc')].join('')
// console.log(typeof(q1),q1)

// let set2 = new Set([2,3,4])
// console.log(set2.add(1)) // .add()返回的还是set 
// console.log(set2.delete(1)) // true ：成功删除1
console.log([...new Set('ababbc')].join(''))
console.log(Array.from(new Set('ababbc')).join(''))

// // ------------- Map ------------------
// const m = new Map ()
// const o = {p:'hello world'}
// console.log(o)
// console.log(typeof(o))

// const map = new Map();

// //1.
// map.set(['a'], 555);
// console.log(map.get(['a'])) // undefined
// //2.
// let arr = ['a']
// map.set(arr,555);
// console.log(map.get(arr))


// //使用
// const map1 = new Map([
//     ['A',1],
//     ["B",2]
// ])

// console.log(typeof(map1.keys()),...Array.from(map1.keys()))