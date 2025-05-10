import React from 'react';

const CartLineInfo = ({ info, removeProductFromCart, showModifyBtn}) => {
    const { product, quantity, subAmount } = info;

    const removeProduct = () => {
        removeProductFromCart(product.code);
    }
    return (
        <div className="product-preview-container">
            <ul>
                <li><img className="product-image" src={product.imageUrl} alt=""/>
                </li>
                <li>代碼：<span>{product.code}</span>
                </li>
                <li>名稱：<span>{product.name}</span></li>
                <li>單價：
                    <span className="price">{product.salesPrice}</span>
                </li>
                <li>數量：{quantity}
                </li>
                <li>小計：
                    <span>{subAmount}</span>
                </li>
                {showModifyBtn && 
                    <li>
                        <a onClick={removeProduct}>
                            刪除商品
                        </a>
                    </li>
                }
            </ul>
        </div>
    );
}

export default CartLineInfo;
