function solve(arg, arg2, arg3) {
    let product = String(arg);
    let city = String(arg2);
    let quantity = Number(arg3);
    let price = 0;

    switch (city) {
        case "Sofia":
            switch (product) {
                case "coffee":
                    price = quantity * 0.5;
                    break;
                case "water":
                    price = quantity * 0.8
                    break;
                case "beer":
                    price = quantity * 1.2
                    break;
                case "sweets":
                    price = quantity * 1.45
                    break;
                case "peanuts":
                    price = quantity * 1.6
                    break;
            }
            console.log(price);
            break;
        case "Plovdiv":
            switch (product) {
                case "coffee":
                    price = quantity * 0.4;
                    break;
                case "water":
                    price = quantity * 0.7
                    break;
                case "beer":
                    price = quantity * 1.15
                    break;
                case "sweets":
                    price = quantity * 1.30
                    break;
                case "peanuts":
                    price = quantity * 1.5
                    break;
            }
            console.log(price);
            break;
        case "Varna":
            switch (product) {
                case "coffee":
                    price = quantity * 0.45;
                    break;
                case "water":
                    price = quantity * 0.7
                    break;
                case "beer":
                    price = quantity * 1.1
                    break;
                case "sweets":
                    price = quantity * 1.35
                    break;
                case "peanuts":
                    price = quantity * 1.55
                    break;
            }
            console.log(price);
    }
}

solve("sweets",
"Sofia",
"2.23")



