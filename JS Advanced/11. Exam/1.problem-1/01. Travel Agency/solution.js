window.addEventListener('load', solution);

function solution() {
  const {nameInput, emailInput, phoneInput, addressInput, codeInput, submitBtn, reservationInfo, editBtn, continueBtn} = setDOMElements();
  
  const ctx = {
    fullname: '',
    email: '',
    phone: '',
    addres: '',
    postCode: ''
  }


  submitBtn.addEventListener('click', createReservationRequest);
  continueBtn.addEventListener('click', sendReservation);
  editBtn.addEventListener('click', editData);

  function createReservationRequest(ev){
    ev.preventDefault();
    
    if(!inputFieldsAreEmpty(nameInput, emailInput)){
      reservationInfo.appendChild(createReservation(nameInput, emailInput, phoneInput, addressInput, codeInput))
      resetInput(nameInput, emailInput, phoneInput, addressInput, codeInput)
      submitBtn.disabled = true;
      editBtn.disabled = false;
      continueBtn.disabled = false;
    }

  };


  function createReservation(nameInput, emailInput, phoneInput, addressInput, codeInput){
    const fragment = document.createDocumentFragment();

    ctx.fullname = nameInput.value;
    ctx.email = emailInput.value;
    ctx.phone = phoneInput.value;
    ctx.addres = addressInput.value;
    ctx.postCode = codeInput.value;

    const nameLi = createEl('li', `Full Name: ${nameInput.value}`);
    const emailLi = createEl('li', `Email: ${emailInput.value}`);
    const phoneLi = createEl('li', `Phone Number: ${phoneInput.value}`);
    const addressLi = createEl('li', `Address: ${addressInput.value}`);
    const postLi = createEl('li', `Postal Code: ${codeInput.value}`);

    fragment.appendChild(nameLi);
    fragment.appendChild(emailLi);
    fragment.appendChild(phoneLi);
    fragment.appendChild(addressLi);
    fragment.appendChild(postLi);

    return fragment;
  };

  function editData(){
    nameInput.value = ctx.fullname;
    emailInput.value = ctx.email;
    phoneInput.value = ctx.phone;
    addressInput.value = ctx.addres;
    codeInput.value = ctx.postCode;

    submitBtn.disabled = false;
    editBtn.disabled = true;
    continueBtn.disabled = true;

    reservationInfo.innerHTML = '';
  }

  function sendReservation(){
    const mainDiv = document.getElementById('block');
    mainDiv.innerHTML = '';

    const thankYouMsg = createEl('h3', 'Thank you for your reservation!');
    mainDiv.appendChild(thankYouMsg);
  };

  function inputFieldsAreEmpty(nameInput, emailInput){
    return nameInput.value == '' || emailInput.value == '';
  };

  function resetInput(nameInput, emailInput, phoneInput, addressInput, codeInput){
    nameInput.value = '';
    emailInput.value = '';
    phoneInput.value = '';
    addressInput.value = '';
    codeInput.value = '';
  };


  function setDOMElements(){
    const nameInput = document.getElementById('fname');
    const emailInput = document.getElementById('email');
    const phoneInput = document.getElementById('phone');
    const addressInput = document.getElementById('address');
    const codeInput = document.getElementById('code');
    const submitBtn = document.getElementById('submitBTN');
    const reservationInfo = document.getElementById('infoPreview');
    const editBtn = document.getElementById('editBTN');
    const continueBtn = document.getElementById('continueBTN');

    return {
      nameInput,
      emailInput,
      phoneInput,
      addressInput,
      codeInput,
      submitBtn,
      reservationInfo,
      editBtn,
      continueBtn
    };
  };


  function createEl(type, content, attribute, attributeValue, styleType, styleValue){
    const newLi = document.createElement(type);

    if(content){
       newLi.innerHTML = content;
    }

    if(attribute){
        newLi.setAttribute(attribute, attributeValue);
    }

    if(styleType){
       newLi.style[styleType] = styleValue; 
    }

    return newLi;
  };
}