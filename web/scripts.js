document.addEventListener("DOMContentLoaded", function() {
    // Función para el scroll suave
    function smoothScroll(target) {
        document.querySelector(target).scrollIntoView({
            behavior: 'smooth'
        });
    }

    // Evento click para el logo
    document.querySelector(".logo img").addEventListener("click", function() {
        smoothScroll(".hero");
    });

    // Evento click para "Acerca"
    document.querySelector("nav ul li:nth-child(1) a").addEventListener("click", function(e) {
        e.preventDefault();
        smoothScroll(".hero");
    });

    // Evento click para "Productos y servicios"
    document.querySelector("nav ul li:nth-child(2) a").addEventListener("click", function(e) {
        e.preventDefault();
        smoothScroll(".features");
    });

    // Evento scroll para mantener la barra de navegación fija
    window.addEventListener("scroll", function() {
        const header = document.querySelector("header");
        header.classList.toggle("sticky", window.scrollY > 0);
    });
});
