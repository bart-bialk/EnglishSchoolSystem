document.addEventListener('DOMContentLoaded', () => {
    const rows = document.querySelectorAll('table#selectionTable tbody tr');

    rows.forEach(row => {
        row.addEventListener('click', () => {
            const isSelected = row.classList.contains('selected');
            rows.forEach(r => r.classList.remove('selected'));

            if (!isSelected) {
                row.classList.add('selected');
            }
        });
    });
});