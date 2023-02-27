if (!undefined) {
    console.log(1)
}
if (!null) {
    console.log(2)
}


const map = new Map ()
map.set("(",")")
map.set("{","}")
map.set("[","]")
console.log(map)
console.log(map.get('('))

// const arr = [1,2,3,4,5]
// arr.splice(1,0,9,8,7)
// console.log(arr)


let arr2 = [1,2,3,4,5]
arr2.splice(-1,0,'c')
console.log(arr2)
