function createPoemsDiv(poems) {
    const ulEl = document.createElement('ul');
    const h2El = document.createElement('h2');
    h2El.textContent = 'Titles';

    for(let i = 0; i < poems.length; i++) {
        const poem = poems[i];
        const liEl = document.createElement('li');
        liEl.textContent = poem.title;
        liEl.style.cursor = "pointer";
        liEl.dataset.poemId = poem.id;
        liEl.setAttribute('id', poem.id)
        liEl.addEventListener('click', onPoemClicked);
        ulEl.appendChild(liEl);
    }
    return ulEl;
}

function onPoemsReceived(){
    const poemDivEl = document.getElementById('poems-content');
    removeAllChildren(poemDivEl);

    const text = this.responseText;
    const poems = JSON.parse(text);

    poemDivEl.appendChild(createPoemsDiv(poems));


   return poemDivEl;
}

function onPoemsLoad() {
    const loginDivEl = document.forms['login-form'];
    const emailEl = loginDivEl.querySelector('input[name="email"]');
    const mail = emailEl.value;


    const params = new URLSearchParams();
    params.append('name', mail);

    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'protected/poems');
    xhr.addEventListener('load', onPoemsReceived);
    xhr.addEventListener('error', onNetworkError);
    xhr.send(params);
}

function createPoemList(poem) {
    const ulEl = document.createElement('ul');
        const h2El = document.createElement('h2');
        h2El.textContent = 'Poem';

        const work = poem;
        const liEl = document.createElement('li');
        const pEl = document.createElement('p');
        const brEl = document.createElement('br');
        liEl.textContent = work.content;
        pEl.textContent = work.date;
        ulEl.appendChild(liEl);
        ulEl.appendChild(brEl);
        ulEl.appendChild(pEl);

        return ulEl;
}

function onPoemClicked() {
    const poemId = this.dataset.poemId;

    const params = new URLSearchParams();
    params.append('id', poemId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoemReceived);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/poem?' + params);
    xhr.send();
}

function onPoemReceived(){
    const poemDivEl = document.getElementById('poem-content');
    removeAllChildren(poemDivEl);

    const text = this.responseText;
    const poem = JSON.parse(text);

    poemDivEl.appendChild(createPoemList(poem));
    showContents(['profile-content', 'poems-content', 'poem-content', 'logout-content'])
}



