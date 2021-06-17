class Contact {
    constructor(firstName, lastName, phone, email) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._phone = phone;
        this._email = email;
        this._online = false;
        this._id = '';
    }

    get firstName() {
        return this._firstName;
    }

    get lastName() {
        return this._lastName;
    }

    get phone(){
        return this._phone;
    }

    get email(){
        return this._email
    }

    get id(){
        return this._id;
    }

    set id(value){
        this._id = value;
    }

    get online() {
        return this._online;
    }

    set online(value) {
        if (typeof value !== 'boolean') {
            throw new TypeError(`Invalid value!`)
        }
        
        this._online = value;
        const currentId = this.id;
        setOnlineStatus(this.firstName + ' ' + this.lastName, this.online);


        function setOnlineStatus(fullName, status){
            if(currentId != ''){
                const titleDiv = Array
                .from(document.querySelectorAll(`#${currentId} div`))
                .filter(x => x.textContent.includes(fullName))[0];
        
                if(titleDiv && status == true){
                    titleDiv.classList.add('online');
                } else if(titleDiv && status == false) {
                    titleDiv.classList.remove('online');
                }
            }
        }
    }

    render(id) {
        this.id = id;
        const firstArticle = Array.from(document.querySelectorAll('article'))[0];

        if(firstArticle && firstArticle.firstElementChild.textContent.includes(`{firstName lastName}`)){
            firstArticle.remove();
        }

        const article = createArticle(this.firstName, this.lastName, this.phone, this.email, this.online);

        document.getElementById(this.id).appendChild(article);


        function createArticle(firstName, lastName, phone, email, status){
            const article = document.createElement('article');
            const divTitle = createEl('div', 'title', `${firstName} ${lastName}`);
            const divInfo = createEl('div', 'info', '');
            divInfo.style.display = 'none';
            const spanPhone = createEl('span', '', '\u260E' + ' ' + phone)
            const spanEmail = createEl('span', '', '\u2709' + ' ' + email)
            const btn = createEl('button', '', '\u2139');
            btn.addEventListener('click', () => {
                divInfo.style.display =  divInfo.style.display ==='none' ? 'block' : 'none';
    
            })
    
            divTitle.appendChild(btn)
            divInfo.appendChild(spanPhone);
            divInfo.appendChild(spanEmail);
            article.appendChild(divTitle);
            article.appendChild(divInfo);

            if(status === true){
                divTitle.classList.add('online')
            }

            return article;
        }

        function createEl(type, attribute, content) {
            const el = document.createElement(type);
            if (content) {
                el.textContent = content;
            }

            if (attribute) {
                el.classList.add(attribute);
            }

            return el;
        } 
    }
}

let contacts = [
    new Contact("Ivan", "Ivanov", "0888 123 456", "i.ivanov@gmail.com"),
  ];
  contacts[0].online = true;
  contacts[0].render('holder');
  
  // After 1 second, change the online status to true
//   setTimeout(() => contacts[1].online = true, 2000);