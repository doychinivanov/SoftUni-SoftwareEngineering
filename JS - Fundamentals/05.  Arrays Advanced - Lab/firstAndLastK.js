function solve(arr) {
    const k = arr.shift();
    const firstHalf = arr.slice(0, k);
    const secondHalf = arr.slice(-k);

    console.log(firstHalf.join(' '));
    console.log(secondHalf.join(' '));
}

solve(
    [3,
        6, 7, 8, 9]       
);