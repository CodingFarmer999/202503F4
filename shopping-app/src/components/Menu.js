import React from 'react';
import { useNavigate } from 'react-router-dom'; 

const Menu = ({user}) => {

    const navigate = useNavigate();

    const changeRoute = (router) => {
        navigate(router);
    }
    return (
        <div className="menu-container" >
            <a onClick={() => changeRoute("/")}>首頁</a>
            |
            <a onClick={() => changeRoute("/productList")}>
                商品列表
            </a>
            |
            <a onClick={() => changeRoute("/shoppingCart")}>
                購物車
            </a>
            |
            <a onClick={() => changeRoute("/orderList")}>
                訂單列表
            </a>
            |
            <a onClick={() => changeRoute("/addProduct")}>
                新增商品
            </a>
            |
        </div>
    );
}

export default Menu;
