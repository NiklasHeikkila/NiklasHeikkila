document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("saveCustomerBtn").addEventListener("click", async () => {
    const customer = {
        name: document.getElementById("nameInput").value
    }

    const res = await fetch("/api/customers", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    })

    document.getElementById("result").textContent =
        await res.text()
    })
})
