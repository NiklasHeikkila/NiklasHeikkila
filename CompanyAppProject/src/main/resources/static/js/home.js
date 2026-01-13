document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("customersBtn").addEventListener("click", async () => {
        window.location.href = "/customers.html";
    })
    document.getElementById("logoutBtn").addEventListener("click", async () => {
        const response = await fetch("/api/logout", {
            method: "POST"
        })
        if (response.ok) {
            window.location.href = "/";
        } else {
            alert("Logout failed");
        }
    })
})