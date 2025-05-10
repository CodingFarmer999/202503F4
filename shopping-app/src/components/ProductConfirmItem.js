import React from 'react';

const ProductConfirmItem = () => {
    return (
        <div className="product-preview-container">
            <ul>
                <li>
                    <img className="product-image" />
                </li>
                <li>
                    Code: <span></span>
                    <input type="hidden" name="code" />
                </li>
                <li>Name: <span></span></li>
                <li>Price:
                    <span className="price">
                    </span>
                </li>
                <li>Quantity: <span></span></li>
                <li>Subtotal:
                    <span className="subtotal">
                    </span>
                </li>
            </ul>
        </div>
    );
}

export default ProductConfirmItem;
