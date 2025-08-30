document.addEventListener("DOMContentLoaded", function () {
    const button = document.getElementById("button");

    button.addEventListener("click", () => {
        button.classList.toggle("flash");

        setTimeout(() => {
            button.classList.remove("flash");
        }, 200);
    });
});
