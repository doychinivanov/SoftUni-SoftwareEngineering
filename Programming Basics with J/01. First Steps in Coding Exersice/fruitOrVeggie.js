function solve(arg) {
    let product = String(arg);

    switch (product) {
        case "banana":
        case "apple":
        case "kiwi":
        case "lemon":
        case "grapes":
        case "cherry":
            console.log("fruit");
            break;
        case "tomato":
        case "cucumber":
        case "pepper":
        case "carrot":
            console.log("vegetable");
            break;
        default:
            console.log("unknown");
    }
}

solve("water")