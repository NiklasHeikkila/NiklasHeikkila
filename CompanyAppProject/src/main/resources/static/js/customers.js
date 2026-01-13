document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("addCustomerBtn").addEventListener("click", async () => {
        window.location.href = "/add-customer.html";
    })
    document.getElementById("showCustomersBtn").addEventListener("click", async () => {
        try {
            const res = await fetch("/api/customers");
            if (res.status === 401) {
                window.location.href = "/";
                return;
            }
            
            if (!res.ok) {
                throw new Error("Failed to load customers");
            }

            const customers = await res.json();

            const list = document.getElementById("customerList");
            list.innerHTML = "";

            customers.forEach(c => {
                const li = document.createElement("li");
                li.textContent = `${c.id}: ${c.name}`;
                list.appendChild(li);
            })

        } catch (err) {
            console.error(err);
            document.getElementById("customerList").innerHTML =
            "<li>Error loading customers</li>";
        }
    })
})