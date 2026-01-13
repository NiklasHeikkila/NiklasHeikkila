document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("loginBtn").addEventListener("click", async () => {
        const user = {
            username: document.getElementById("usernameInput").value,
            password: document.getElementById("passwordInput").value
        }

        // Validate input
        if (!user.username || !user.password) {
            alert("Please enter both username and password");
            return;
        }

        try {
            // Send login request to backend
            const response = await fetch("/api/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            const result = await response.json();

            if (response.ok) {
                alert("Login successful!");
                // Redirect to home page
                window.location.href = "/home.html";
            } else {
                alert(result.message || "Login failed. Please check your credentials.");
            }
        } catch (error) {
            console.error("Error:", error);
            alert("An error occurred. Please try again.");
        }
    })
})