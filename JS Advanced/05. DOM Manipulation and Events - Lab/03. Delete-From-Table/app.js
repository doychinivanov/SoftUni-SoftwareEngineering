function deleteByEmail() {
    const input = document.querySelector('label>input');
    const emails = Array.from(document.querySelectorAll('tbody>tr>td')).filter((x, index) => index % 2 != 0);
    const resultField = document.getElementById('result');

    emails.forEach(email => {
        if(email.textContent == input.value){
            resultField.textContent = 'Deleted';
            email.parentNode.remove();
        } else {
            resultField.textContent = 'Not found.';
        }
    });

    input.value = '';
}