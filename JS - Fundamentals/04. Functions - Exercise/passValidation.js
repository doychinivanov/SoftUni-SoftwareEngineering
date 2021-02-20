function passValid(pass) {

    function isValidLength(pass) {
        if (pass.length >= 6 && pass.length <= 10) {
            return true
        } else {
            return `Password must be between 6 and 10 characters`
        }
    }

    function isValisChar(pass) {
        let isValid = true;
        for (let i = 0; i < pass.length; i++) {
            let code = pass[i].charCodeAt(0);
            if (code >= 65 && code <= 90 ||
                code >= 97 && code <= 122 ||
                code >= 48 && code <= 57) {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }

        return isValid ? true : `Password must consist only of letters and digits`;
    }

    function atLeastTwoDigits(pass) {
        let digits = 0;
        for (let i = 0; i < pass.length; i++) {
            let code = pass[i].charCodeAt(0);
            code >= 48 && code <= 57 ? digits++ : digits;
        }

        return digits >= 2 ? true : `Password must have at least 2 digits`;
    }

    let result = [];
    if (isValidLength(pass) !== true) {
        result.push(isValidLength(pass))
    }
    if (isValisChar(pass) !== true) {
        result.push(isValisChar(pass));
    }
    if (atLeastTwoDigits(pass) !== true) {
        result.push(atLeastTwoDigits(pass));
    }
   
    if(isValisChar(pass) ===true && isValidLength(pass) === true && atLeastTwoDigits(pass) === true){
        result.push(`Password is valid`)
    }
        
    return result.join("\n")
}

console.log(passValid('logIn'));