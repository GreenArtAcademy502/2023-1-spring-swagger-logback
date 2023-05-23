(function() {
    const URLSearch = new URLSearchParams(location.search);
    const $tableList = document.querySelector('#table_list');
    const getBoard = (page) => {
        const params = {
            page,
            row: 30
        }
        fetch(`/board?${new URLSearchParams(params)}`)
            .then(res => res.json())
            .then(data => {
                if(data.length === 0) {
                    alert('내용이 없습니다.')
                    return;
                }

                makeList(data);
            });
    }

    const makeList = (list) => {
        $tableList.innerHTML = null;
        list.forEach(item => makeItem(item));
    }

    const makeItem = (item) => {
        const tr = document.createElement('tr')
        tr.className = 'cursor';
        tr.innerHTML = `
            <td>${item.iboard}</td>
            <td>${item.title}</td>
            <td>${item.writer}</td>
            <td>${item.createdAt}</td>
        `;
        tr.addEventListener('click', () => {
            location.href = `/static/html/boardDetail.html?iboard=${item.iboard}`;
        })
        $tableList.append(tr);
    }
    let page =URLSearch.get('page');
    if(!(page > 1)) { page = 1; }
    getBoard(page);


    const $paging = document.querySelector('#paging');

    const getPagingCnt = () => {
        makePagingList(20)
    };

    const makePagingList = (n) => {
        for(let i=1; i<=n; i++) {
            const span = document.createElement('span');
            span.className = 'span-page cursor'
            span.textContent = i;
            span.addEventListener('click', () => {
                location.href = `/static/html/board.html?page=${i}`;
            })
            $paging.appendChild(span);
        }
    }
    getPagingCnt();

})();