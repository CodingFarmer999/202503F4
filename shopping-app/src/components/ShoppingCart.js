import React, { useLayoutEffect, useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import { request } from '../utils/AxiosUtils';
import CartLineInfo from './CartLineInfo';
import EmptyCart from './EmptyCart';

const ShoppingCart = () => {
    const navigator = useNavigate();
    const location = useLocation();

    const [cart, setCart] = useState({});
    const { itemList } = cart;
    
    useLayoutEffect(() => {
        request(
            "GET",
            "cart"
        ).then(response => {
            let cart = response.data;
            console.log("cart", cart);
            setCart(cart);
        });
    // 透過location判斷當下的是否需要重新Render
    }, [location]);

    const removeProductFromCart = (code) => {
        request(
            "DELETE",
            `cart/${code}`
        ).then(response => {
            let cart = response.data;
            console.log("cart", cart);
            setCart(cart);
        });
    }

    return (
        <>
            <div className="page-title">我的購物車</div>
            {
                (itemList && itemList.length === 0) && <EmptyCart />
            }

            {
                itemList && itemList.map(info => <CartLineInfo key={info.product.id} info={info} showModifyBtn={true} removeProductFromCart={removeProductFromCart}/>)
            
            }
            {
                (itemList && itemList.length > 0 ) && (
                    <>
                        <div style={{clear: "both"}}></div>
                        <a className="navi-item" onClick={() => {navigator("/checkoutConfirm")}}>結帳</a>
                        <a className="navi-item" onClick={() => {navigator("/productList")}}>繼續購買</a>
                    </>
                )
            }
        </>
    );
}

export default ShoppingCart;
