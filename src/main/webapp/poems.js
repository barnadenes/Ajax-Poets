

function onPoemClicked() {
    const userId = this.dataset.user_id;

    const params = new URLSearchParams();
    params.append('id', userId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoemResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/poem?' + params.toString());
    xhr.send();
}

function appendPoem(poem) {
    const idUlEl = document.createElement('ul');
    idUlEl.textContent = poem.user_id;

    const liEl = document.createElement('li');
    const pEl = document.createElement('p');
    pEl.textContent = poem.title;

    aEl.dataset.shopId = shop.id;
    aEl.addEventListener('click', onShopClicked);

    const nameTdEl = document.createElement('td');
    nameTdEl.appendChild(aEl);

    const trEl = document.createElement('tr');
    trEl.appendChild(idTdEl);
    trEl.appendChild(nameTdEl);
    shopsTableBodyEl.appendChild(trEl);
}

function appendShops(shops) {
    removeAllChildren(shopsTableBodyEl);

    for (let i = 0; i < shops.length; i++) {
        const shop = shops[i];
        appendShop(shop);
    }
}

function onPoemsLoad() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoemsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/poems');
    xhr.send();
}

function onPoemsResponse() {
    divEl = document.getElementById('poems-content');
    removeAllChildren(divEl);

    const poem = JSON.parse(this.responseText);
    poemDivEl = document.getElementById('poems-content');

    
}
