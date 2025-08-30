document.addEventListener('DOMContentLoaded', () => {
    const addBtn = document.getElementById('studentAddButton');

    addBtn.addEventListener('click', () => {
        addBtn.classList.toggle('flash');
        setTimeout(() => {
            addBtn.classList.remove('flash');
        }, 200);

        const selectedRow = document.querySelector('tr.selected');
        if (!selectedRow) {
            return;
        }

        const groupId = document.getElementById('groupId').value;
        const studentId = selectedRow.dataset.studentId;

        fetch(`/students/${groupId}/addStudent/${studentId}`, {
            method: 'POST'
        })
            .then(response => {
                return response.text();
            })
            .then(text => {
                alert(text)
                location.reload();
            });


    });
});
