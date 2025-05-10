import React, { useState } from "react";
import { Toast, ToastContainer, Button } from "react-bootstrap";
import { request } from "../utils/AxiosUtils";

import "bootstrap/dist/css/bootstrap.min.css";

const PurchaseButton = ({ code }) => {
  const [showToast, setShowToast] = useState(false);
  const [toastMessage, setToastMessage] = useState("");

  /**
   * 商品加入購物車
   */
  const handlePurchase = (event, code) => {
    event.preventDefault();
    console.log("addProductToCart Code: ", code);

    request("POST", `cart/${code}`).then((response) => {
      console.log(response);
      setToastMessage("商品加入購物車成功");

      // 顯示 Toast
      setShowToast(true);

      // 0.5秒後自動關閉 Toast
      setTimeout(() => {
        setShowToast(false);
      }, 1000);
    });
  };

  return (
    <>
      <Button onClick={(event) => handlePurchase(event, code)}>加入購物車</Button>

      <ToastContainer style={{ position: 'fixed', top: '10px', left: '50%', transform: 'translateX(-50%)', zIndex: 9999 }}>
        <Toast show={showToast} onClose={() => setShowToast(false)}>
          <Toast.Body style={{ backgroundColor: '#04AA6D', color: 'white', textAlign: 'center' }}>{toastMessage}</Toast.Body>
        </Toast>
      </ToastContainer>
    </>
  );
};

export default PurchaseButton;
