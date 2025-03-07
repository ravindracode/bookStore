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
