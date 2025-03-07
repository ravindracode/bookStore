// Handle loading state
window.addEventListener('load', () => {
  const loadingOverlay = document.querySelector('.loading-overlay');
  loadingOverlay.classList.add('hidden');
});

// Form switching functionality
const loginForm = document.getElementById('loginForm');
const signupForm = document.getElementById('signupForm');
const showSignupLink = document.getElementById('showSignup');
const showLoginLink = document.getElementById('showLogin');

showSignupLink.addEventListener('click', (e) => {
  e.preventDefault();
  loginForm.classList.add('hidden');
  signupForm.classList.remove('hidden');
});

showLoginLink.addEventListener('click', (e) => {
  e.preventDefault();
  signupForm.classList.add('hidden');
  loginForm.classList.remove('hidden');
});



