function validate() {
    const nameReg = /^[a-zA-Z\d]{3,20}$/g;
    const passReg = /^[\w]{5,15}$/g;
    const emailReg = /\@[^\.]*\./g;

    //Get div with valid form
    const validForm = document.querySelector('#valid');

    //Get Submit Button
    const sumbitBtn = document.querySelector('#submit');
    sumbitBtn.addEventListener('click', toSubmit)

    //Get checkbox and company info section
    const checkbox = document.querySelector('#company');
    const compnyinfo = document.querySelector('#companyInfo');

    checkbox.addEventListener('change', (ev) => {
        if (ev.target.checked) {
            compnyinfo.style.display = 'block';
        } else {
            compnyinfo.style.display = 'none';
        }
    });

    function toSubmit(ev) {
        ev.preventDefault();
        //Get inputs
        const name = document.querySelector('#username');
        const email = document.querySelector('#email');
        const password = document.querySelector('#password');
        const confirmPass = document.querySelector('#confirm-password');
        let everythingIsValid = true;


        //Set border color in case of mistake
        checkName(name.value) ? (name.style.borderColor = 'none') : (name.style.borderColor = 'red', everythingIsValid = false);
        checkPass(password.value) ? (password.style.borderColor = 'none', confirmPass.style.borderColor = 'none') : (password.style.borderColor = 'red', confirmPass.style.borderColor = 'red', everythingIsValid = false);


        if (password.value !== confirmPass.value) {
            confirmPass.style.borderColor = 'red';
            password.style.borderColor = 'red';
        }

        checkEmail(email.value) ? (email.style.borderColor = 'none') : (email.style.borderColor = 'red', everythingIsValid = false);


        if (checkbox.checked) {
            const companyNum = document.querySelector('#companyNumber');
            (companyNum.value >= 1000 && companyNum.value <= 9999) ? (companyNum.style.borderColor = 'none') : (companyNum.style.borderColor = 'red', everythingIsValid = false);
        }

        if (everythingIsValid) {
            validForm.style.display = 'block';
        } else {
            validForm.style.display = 'none';
        }
    }


    function checkName(n) {
        return nameReg.test(n)
    }

    function checkPass(p) {
        return passReg.test(p)
    }

    function checkEmail(em) {
        return emailReg.test(em);
    }
}
