document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Prevent the form from submitting the normal way

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const loginData = {
        username: username,
        password: password
    };

    try {
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData)
        });

        const result = await response.json();

        if (result.success) {
            document.getElementById('message').textContent = 'Login Successful!';
        } else {
            document.getElementById('message').textContent = 'Invalid Credentials';
        }
    } catch (error) {
        document.getElementById('message').textContent = 'Error connecting to server';
    }
});
  