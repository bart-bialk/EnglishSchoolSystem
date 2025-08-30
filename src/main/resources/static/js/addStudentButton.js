document.addEventListener('DOMContentLoaded', () => {
    const addBtn = document.getElementById('groupAddButton');

    addBtn.addEventListener('click', () => {
        addBtn.classList.toggle('flash');
        setTimeout(() => {
            addBtn.classList.remove('flash');
        }, 200);

        const selectedRow = document.querySelector('tr.selected');
        if (!selectedRow) {
            return;
        }

        const studentCount = parseInt(selectedRow.dataset.studentCount, 10);
        const maxStudents = parseInt(document.getElementById("maxStudents").value, 10);

        if (studentCount >= maxStudents) {
            alert("Group has max participants!");
            return;
        }

        const groupId = selectedRow.dataset.groupId;
        window.location.href = `/students/${groupId}`;
    });
});
