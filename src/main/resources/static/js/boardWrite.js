(function() {
    $frm = document.querySelector('#frm');
    $submit = document.querySelector('#submit');
    $submit.addEventListener('click', () => {
        const params = {
            title: $frm.title.value,
            writer: $frm.writer.value,
            ctnt: $frm.ctnt.value
        }

        fetch('/board', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(params)
        })
            .then(res => res.json())
            .then(data => {
                if(data === 1) {
                    location.href = '/static/html/board.html';
                    return;
                }
                alert('글 등록에 실패하였습니다.')
            })
    });

})();