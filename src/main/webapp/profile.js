function onProfileLoad(user) {
    setUnauthorized()
    clearMessages();
    showContents(['profile-content', 'logout-content', 'poems-content', 'counter-content']);


    const userNameSpanEl = document.getElementById('user-name');
    const userEmailSpandEl = document.getElementById('user-email');
    const userPasswordSpanEl = document.getElementById('user-password');

    userNameSpanEl.textContent = user.name;
    userEmailSpandEl.textContent = user.email;
    userPasswordSpanEl.textContent = user.password;
}
