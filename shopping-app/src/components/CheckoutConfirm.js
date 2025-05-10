import React, { useState, useEffect } from "react";
import { request } from "../utils/AxiosUtils";
import CartLineInfo from "./CartLineInfo";

const CheckoutConfirm = () => {
  const [cart, setCart] = useState({});
  const [shippingMethod, setShippingMethod] = useState({
    shippingType: "homeDelivery",
    recipient: "",
    phone: "",
    address: "",
  });
  const { totalAmount, itemList } = cart;

  useEffect(() => {
    request("GET", "cart").then((response) => {
      let cart = response.data;
      console.log("cart", cart);
      setCart(cart);
    });
  }, []);

  const changeShippingMethodHandler = (event) => {
    const { name, value } = event.target;
    setShippingMethod((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const checkout = () => {
    request("POST", `cart/checkout`, shippingMethod).then((response) => {
      console.log(response);
      // 將確認頁的資料往shippingCartConfirm傳遞
      let cartInfo = response.data;
      // state是固定
      //navigate("/shippingCartConfirm", { state: cartInfo });
    });
  };

  return (
    <>
      <div className="page-title">確認頁</div>
      <table>
        <tbody>
          <tr>
            <td>收件人 *</td>
            <td>
              <input name="recipient" onChange={changeShippingMethodHandler} />
            </td>
            <td>
              <span className="error-message"></span>
            </td>
          </tr>
          <tr>
            <td>電話 *</td>
            <td>
              <input name="phone" onChange={changeShippingMethodHandler} />
            </td>
            <td>
              <span className="error-message"></span>
            </td>
          </tr>
          <tr>
            <td>收件地址 *</td>
            <td>
              <input name="address" onChange={changeShippingMethodHandler} />
            </td>
            <td>
              <span className="error-message"></span>
            </td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>
              <input type="submit" value="結帳" onClick={checkout} />
              <input type="reset" value="重置" />
            </td>
          </tr>
        </tbody>
      </table>

      <div>購物車總計：{totalAmount}</div>
      {itemList &&
        itemList.map((info) => <CartLineInfo key={info.product.id} info={info} />)}
    </>
  );
};

export default CheckoutConfirm;
