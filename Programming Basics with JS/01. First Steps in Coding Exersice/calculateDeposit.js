function deposite(depositeSum, termToReturn, interestRate) {
    depositeSum = Number(depositeSum);
    termToReturn = Number(termToReturn);
    interestRate = Number(interestRate);

    let increasePerYear = depositeSum * interestRate / 100;
    let forMonth = increasePerYear / 12;
    let result = depositeSum + termToReturn * forMonth;
    console.log(result);
}

deposite("200", "3", "5.7");
deposite("2350", "6", "7")