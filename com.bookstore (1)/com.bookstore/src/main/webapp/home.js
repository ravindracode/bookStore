// your code goes here
document.addEventListener('DOMContentLoaded', () => {
    const hamburger = document.querySelector('.hamburger');
    const navLinks = document.querySelector('.nav-links');

    hamburger.addEventListener('click', () => {
        hamburger.classList.toggle('active');
        navLinks.classList.toggle('active');
    });

    // Close mobile menu when clicking outside
    document.addEventListener('click', (e) => {
        if (!hamburger.contains(e.target) && !navLinks.contains(e.target)) {
            hamburger.classList.remove('active');
            navLinks.classList.remove('active');
        }
    });

    // Close mobile menu when clicking a link
    navLinks.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', () => {
            hamburger.classList.remove('active');
            navLinks.classList.remove('active');
        });
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.querySelector(".search-input");
    const genreCards = document.querySelectorAll(".genre-card");

    searchInput.addEventListener("keyup", function () {
        let filter = searchInput.value.toLowerCase();

        genreCards.forEach(card => {
            let genreName = card.querySelector("h3").textContent.toLowerCase();
            let description = card.querySelector(".book-description").textContent.toLowerCase();

            if (genreName.includes(filter) || description.includes(filter)) {
                card.style.display = "block"; // Show matching card
            } else {
                card.style.display = "none"; // Hide non-matching card
            }
        });
    });
});






