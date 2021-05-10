function solve(arg, arg2, arg3) {
    let fruit = String(arg);
    let day = String(arg2);
    let amount = Number(arg3);
    let price = 0;

    if (day != "Monday" && day != "Tuesday" && day != "Wednesday" && day != "Thursday" && day != "Friday" && day != "Saturday" && day != "Sunday") {
        console.log("error");
    } else {
        switch (fruit) {
            case "banana":
                if (day != "Saturday" && day != "Sunday") {
                    price = 2.5 * amount;
                } else {
                    price = 2.7 * amount;
                }
                console.log(price.toFixed(2));
                break;
            case "apple":
                if (day != "Saturday" && day != "Sunday") {
                    price = 1.2 * amount;
                } else {
                    price = 1.25 * amount;
                }
                console.log(price.toFixed(2));
                break;
            case "orange":
                if (day != "Saturday" && day != "Sunday") {
                    price = 0.85 * amount;
                } else {
                    price = 0.9 * amount;
                }
                console.log(price.toFixed(2));
                break;
            case "grapefruit":
                if (day != "Saturday" && day != "Sunday") {
                    price = 1.45 * amount;
                } else {
                    price = 1.6 * amount;
                }
                console.log(price.toFixed(2));
                break;
            case "kiwi":
                if (day != "Saturday" && day != "Sunday") {
                    price = 2.7 * amount;
                } else {
                    price = 3 * amount;
                }
                console.log(price.toFixed(2));
                break;
            case "pineapple":
                if (day != "Saturday" && day != "Sunday") {
                    price = 5.5 * amount;
                } else {
                    price = 5.6 * amount;
                }
                console.log(price.toFixed(2));
                break;
            case "grapes":
                if (day != "Saturday" && day != "Sunday") {
                    price = 3.85 * amount;
                } else {
                    price = 4.2 * amount;
                }
                console.log(price.toFixed(2));
                break;
            default: {
                console.log("error");
                break;
            }
        }
    }


}

solve("orange",
    "Sunday",
    "3")









