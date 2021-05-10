function solve(n, inputMetric, outputMetric) {
    n = Number(n);
    let result = n;

    if (inputMetric === "mm") {
        if (outputMetric === "m") {
            result = n / 1000;
        } else if (outputMetric === "cm") {
            result = n / 10;
        }
    }
    if (inputMetric === "m") {
        if (outputMetric === "cm") {
            result = n * 100;
        } else if (outputMetric == "mm") {
            result = n * 1000;
        }
    }
    if (inputMetric === "cm") {
        if (outputMetric === "m") {
            result = n / 100;
        } else if (outputMetric == "mm") {
            result = n * 10;
        }
    }

    console.log(result.toFixed(3));

}

solve("12", "mm", "m")
solve("150", "m", "cm")
solve("45", "cm", "mm")