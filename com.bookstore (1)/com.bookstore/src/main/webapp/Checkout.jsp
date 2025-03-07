<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout Page</title>
    <link rel="stylesheet" href="checkout.css">
</head>
<body>
    <div class="container">
        <h1>Checkout</h1>
        <form id="checkoutForm" action="Checkout" method="post">
            <!-- Delivery Address Section -->
            <div class="section delivery-section">
                <h2>Delivery Address</h2>
                <div class="input-group">
                    <input type="text" id="address" name="address" placeholder="Complete Address" required>
                    <input type="text" id="landmark" name="landmark" placeholder="Landmark (Optional)">
                    <div class="address-row">
                        <input type="text" id="city" name="city" placeholder="City" required>
                        <input type="text" id="pincode" name="pincode" placeholder="Pincode" required maxlength="6">
                    </div>
                </div>
            </div>

          <div class="section payment-section">
                <h2>Payment Method</h2>
                <div class="payment-options">
                    <div class="payment-option" data-method="upi">
                        <div class="payment-header">
                            <span class="payment-icon">💳</span>
                            <span>UPI</span>
                        </div>
                        <div class="payment-content hidden">
                            <input type="text" placeholder="Enter UPI ID" id="upiId" name="upiId">
                        </div>
                    </div>

                    <div class="payment-option" data-method="card">
                        <div class="payment-header">
                            <span class="payment-icon">💳</span>
                            <span>Credit/Debit Card</span>
                        </div>
                        <div class="payment-content hidden">
                            <input type="text" placeholder="Card Number" name="cardNumber" maxlength="16">
                            <div class="card-details">
                                <input type="text" placeholder="MM/YY" name="expiryDate" maxlength="5">
                                <input type="text" placeholder="CVV" name="cvv" maxlength="3">
                            </div>
                        </div>
                    </div>

                    <div class="payment-option" data-method="cod">
                        <div class="payment-header">
                            <span class="payment-icon">💵</span>
                            <span>Cash on Delivery</span>
                        </div>
                    </div>
                </div>
            </div>
          

            <!-- Order Summary Section -->
            <div class="section order-summary">
                <h2>Order Summary</h2>
                <p>Your order details will be shown on the confirmation page.</p>
            </div>

            <!-- Place Order Button -->
            <button type="submit" class="place-order-btn">Place Order</button>
        </form>
    </div>
</body>
<script>

document.addEventListener('DOMContentLoaded', () => {
    const paymentOptions = document.querySelectorAll('.payment-option');
    const checkoutForm = document.getElementById('checkoutForm');
    const placeOrderButton = document.querySelector('.place-order-btn');

    // Handle payment method selection
    paymentOptions.forEach(option => {
        option.addEventListener('click', () => {
            // Remove "selected" class from all options and hide their content
            paymentOptions.forEach(opt => {
                opt.classList.remove('selected');
                const content = opt.querySelector('.payment-content');
                if (content) {
                    content.classList.add('hidden');
                }
            });

            // Add "selected" class to the clicked option and show its content
            option.classList.add('selected');
            const content = option.querySelector('.payment-content');
            if (content) {
                content.classList.remove('hidden');
            }

            // Enable the Place Order button when a payment method is selected
            placeOrderButton.disabled = false;
        });
    });

    // Handle form submission
    checkoutForm.addEventListener('submit', (e) => {
        const selectedPayment = document.querySelector('.payment-option.selected');

        // If no payment option is selected, prevent form submission
        if (!selectedPayment) {
            e.preventDefault();
            return;
        }

        const paymentMethod = selectedPayment.dataset.method;

        // Validate based on the selected payment method
        switch (paymentMethod) {
            case 'upi':
                const upiId = document.getElementById('upiId').value.trim();
                if (!upiId) {
                    e.preventDefault();
                    highlightField('upiId');
                }
                break;
            case 'card':
                const cardNumber = document.querySelector('[name="cardNumber"]').value.trim();
                const expiryDate = document.querySelector('[name="expiryDate"]').value.trim();
                const cvv = document.querySelector('[name="cvv"]').value.trim();

                if (!cardNumber || !expiryDate || !cvv) {
                    e.preventDefault();
                    highlightField('cardNumber');
                    highlightField('expiryDate');
                    highlightField('cvv');
                }
                break;
           
        }
    });

    // Utility function to highlight invalid fields
    function highlightField(fieldId) {
        const field = document.getElementById(fieldId);
        if (field) {
            field.classList.add('error'); // Add error styling
            field.addEventListener('input', () => field.classList.remove('error')); // Remove error on input
        }
    }
});


</script>
</html>
