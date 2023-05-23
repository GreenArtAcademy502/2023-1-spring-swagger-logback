(function() {
    const $container = document.querySelector('#container');
    const $content = $container.querySelector('#content');
    const $cmt = $container.querySelector('#cmt');

    const URLSearch = new URLSearchParams(location.search);
    const iboard = URLSearch.get('iboard');

    const getBoardDetail = (iboard) => {
        fetch(`/board/${iboard}`)
            .then(res => res.json())
            .then(data => {
                if(!data) {
                    alert('내용이 없습니다.')
                    return;
                }
                makeData(data);
            });
    }
    getBoardDetail(iboard);

    const makeData = (data) => {
        const title = document.createElement('h1');
        title.textContent = data.title;
        $content.appendChild(title);

        const writer = document.createElement('div');
        writer.textContent = `작성자 : ${data.writer}`;
        $content.appendChild(writer);

        const createdAt = document.createElement('div');
        createdAt.textContent = `작성일시 : ${data.createdAt}`;
        $content.appendChild(createdAt);

        const ctnt = document.createElement('div');
        ctnt.textContent = `${data.ctnt}`;
        $content.appendChild(ctnt);
    }

    const getBoardCmt = (iboard) => {
        fetch(`/board/${iboard}/cmt`)
            .then(res => res.json())
            .then(data => {
                if(!data) {
                    return;
                }
                makeCmtList(data);
            });
    }
    const makeCmtList = (list) => {
        list.forEach(item => {
            makeCmtItem(item);
        });
    }

    const makeCmtItem = (item) => {
        const row = document.createElement('div');
        row.innerHTML = `
            ${item.icmt} | ${item.ctnt} | ${item.writer} | ${item.createdAt}
        `;
        $cmt.append(row);
    }
    getBoardCmt(iboard);
})();