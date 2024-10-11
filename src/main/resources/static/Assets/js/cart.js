// cart.js

// Example product data (this would come from the backend in a real-world scenario)
const cartItems = [
    { id: 1, name: "Product 1", price: 10.00, quantity: 2 },
    { id: 2, name: "Product 2", price: 20.00, quantity: 1 },
    { id: 3, name: "Product 3", price: 15.00, quantity: 3 }
];

// Function to render cart items
function renderCartItems() {
    const cartContent = document.getElementById('cart-content');
    cartContent.innerHTML = ''; // Clear previous content

    let totalPrice = 0;

    cartItems.forEach(item => {
        const row = document.createElement('tr');

        // Calculate total price for the item
        const itemTotal = item.price * item.quantity;
        totalPrice += itemTotal;

        // Create table row for each product
        row.innerHTML = `
            <td>${item.name}</td>
            <td>$${item.price.toFixed(2)}</td>
            <td>${item.quantity}</td>
            <td>$${itemTotal.toFixed(2)}</td>
            <td><button class="remove-btn" onclick="removeItem(${item.id})">Remove</button></td>
        `;

        cartContent.appendChild(row);
    });// cart.js

// Example product data (this would come from the backend in a real-world scenario)
    const cartItems = [
        { id: 1, name: "Product 1", price: 10.00, quantity: 2 },
        { id: 2, name: "Product 2", price: 20.00, quantity: 1 },
        { id: 3, name: "Product 3", price: 15.00, quantity: 3 }
    ];

// Function to render cart items
    function renderCartItems() {
        const cartContent = document.getElementById('cart-content');
        cartContent.innerHTML = ''; // Clear previous content

        let totalPrice = 0;

        cartItems.forEach(item => {
            const row = document.createElement('tr');

            // Calculate total price for the item
            const itemTotal = item.price * item.quantity;
            totalPrice += itemTotal;

            // Create table row for each product
            row.innerHTML = `
            <td>${item.name}</td>
            <td>$${item.price.toFixed(2)}</td>
            <td>${item.quantity}</td>
            <td>$${itemTotal.toFixed(2)}</td>
            <td><button class="remove-btn" onclick="removeItem(${item.id})">Remove</button></td>
        `;

            cartContent.appendChild(row);
        });

        // Update total price in the summary
        document.getElementById('total-price').textContent = `Total Price: $${totalPrice.toFixed(2)}`;
    }

// Function to remove item from cart
    function removeItem(itemId) {
        const itemIndex = cartItems.findIndex(item => item.id === itemId);
        if (itemIndex > -1) {
            cartItems.splice(itemIndex, 1);
            renderCartItems(); // Re-render cart after removing the item
        }
    }

// Initial render of the cart
    renderCartItems();


    // Update total price in the summary
    document.getElementById('total-price').textContent = `Total Price: $${totalPrice.toFixed(2)}`;
}

// Function to remove item from cart
function removeItem(itemId) {
    const itemIndex = cartItems.findIndex(item => item.id === itemId);
    if (itemIndex > -1) {
        cartItems.splice(itemIndex, 1);
        renderCartItems(); // Re-render cart after removing the item
    }
}

// Initial render of the cart
renderCartItems();
