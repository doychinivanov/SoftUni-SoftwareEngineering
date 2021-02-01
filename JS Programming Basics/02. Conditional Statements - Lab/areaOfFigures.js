function solve (fig, A, B,) {
    let sideA = Number(A);
    let sideB = Number (B);

    if(fig == "square"){
        let squareArea = sideA * sideA;
        console.log(squareArea.toFixed(3));
    } else if (fig == "rectangle"){
        let rectangleArea = sideA * sideB;
        console.log(rectangleArea.toFixed(3));
    } else if(fig == "circle"){
        let circleArea = Math.PI * sideA * sideA;
        console.log(circleArea.toFixed(3));
    } else if(fig == "triangle"){
        let triangleArea = (sideA * sideB) / 2;
        console.log(triangleArea.toFixed(3));
    }
}

solve("square", "5")
solve("rectangle", "7", "2.5")
solve("circle", "6")
solve("triangle", "4.5", "20")