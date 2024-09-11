console.log("script loaded");
document.addEventListener('DOMContentLoaded', function() {
    const themeToggleButton = document.getElementById('theme_change_button');
    const rootElement = document.documentElement; // Refers to the <html> element

    // Check if a theme is already selected by the user
    const currentTheme = localStorage.getItem('theme') || 'light';

    if (currentTheme === 'dark') {
        rootElement.classList.add('dark');
        themeToggleButton.querySelector('span').textContent = 'Dark';
    }

    themeToggleButton.addEventListener('click', function() {
        rootElement.classList.toggle('dark');
        
        const isDarkMode = rootElement.classList.contains('dark');
        themeToggleButton.querySelector('span').textContent = isDarkMode ? 'Dark' : 'Light';
        
        // Save the user's preference in localStorage
        localStorage.setItem('theme', isDarkMode ? 'dark' : 'light');
    });
});

