import React from 'react';
import { useLocation } from 'react-router-dom';
import ProductItem from './ProductItem';

const ShippingCartConfirm = () => {
    const { state } = useLocation();
    console.log("state", state);

    const { customerInfo, cartLines, quantityTotal, amountTotal} = state;
    return (
        <>
            <div className="page-title">確認表單</div>
            <div className="customer-info-container">
                <h3>客戶資料:</h3>
                <ul>
                    <li>客戶名字: <span>{customerInfo.name}</span></li>
                    <li>電子郵件: <span>{customerInfo.email}</span></li>
                    <li>電話: <span>{customerInfo.phone}</span></li>
                    <li>地址: <span>{customerInfo.address}</span></li>
                </ul>
                <h3>購物車列表:</h3>
                <ul>
                    <li>商品總數量: <span>{quantityTotal}</span></li>
                    <li>商品總金額:
                        <span className="total">{amountTotal}</span>
                    </li>
                </ul>
            </div>
            <form method="POST">
                <a className="navi-item" >
                    修改購物車
                </a>
                <a className="navi-item">
                    修改客戶資料
                </a>
                <input type="submit" value="Send" className="button-send-sc" />
            </form>
            <div className="container">
                {
                    // 商品列表
                    // productList.map(p => <ProductItem key={p.code} product={p}/>)
                }
                <div className="product-preview-container">
                    <ul>
                        <li>
                            <img className="product-image" />
                        </li>
                        <li>
                            Code: <span></span>
                            <input type="hidden" name="code"/>
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
            </div>
        </>
    );
}

export default ShippingCartConfirm;
