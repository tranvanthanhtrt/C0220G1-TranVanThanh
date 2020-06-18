function httpGet(url: string): Promise<any> {
    return new Promise(function (resolve, reject) {
        const request = new XMLHttpRequest();
        request.onload = function () {
            if (this.status === 200) {
                // Success
                resolve(this.response);
            } else {
                // Something went wrong (404 etc.)
                reject(new Error(this.statusText));
            }
        };
        request.onerror = function () {
            reject(new Error('XMLHttpRequest Error: ' + this.statusText));
        };
        request.open('GET', url);
        request.send();
    });
}

function createItem(text: string): HTMLLIElement {
    const item = document.createElement('li') as HTMLLIElement;
    item.textContent = text;
    return item;
}



// const container = document.getElementsByClassName('.list');

function main() {
    let inputValue = (<HTMLInputElement>document.getElementById('search')).value;
    let url='https://api.github.com/search/repositories?q='+inputValue;
    httpGet(url).then(
        function (value) {
            let object = JSON.parse(value);
            let items = object.items;
            let div=document.getElementById('list');
            div.innerHTML='';
            for (let i = 0; i < items.length; i++) {
                const li = createItem(items[i].name);

                // console.log(container);

                div.appendChild(li);
                var a = document.createElement('a');
                var linkText = document.createTextNode(items[i].html_url);
                a.appendChild(linkText);
                a.href = items[i].html_url;
                div.appendChild(a);
            }
        },
        function (reason) {
            console.error('Something went wrong', reason);
        }
    );
}


// parseJSON
// function parseResponse(value: string) {
//     try {
//         return JSON.parse(value);
//     } catch (_) {
//         return value;
//     }
// }