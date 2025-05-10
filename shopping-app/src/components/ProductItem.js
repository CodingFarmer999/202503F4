import React, { useState, useEffect } from "react";
import { request } from "../utils/AxiosUtils";
import axios from "axios";
import PurchaseButton from "./PurchaseButton";

const ProductItem = ({ product }) => {
  const { code, name, listPrice, salesPrice, quantity, imageName, imageUrl } = product;

  
  //const [imageUrl, setImageUrl] = useState("");

//   useEffect(() => {
//     fetchImage(imageName);
//   }, []);

//   Image Server 使用方式
//   const fetchImage = async (filename) => {
//     try {
//       // 取得圖片的 API 路徑
//       const response = await axios.get(
//         `http://localhost:8085/image/${filename}`,
//         {
//           responseType: "blob", // 必須是 blob，這樣 Axios 才能正確處理圖片
//         }
//       );

//       // 建立圖片的 URL 來顯示
//       const imageBlob = response.data;
//       const imageObjectURL = URL.createObjectURL(imageBlob);
//       setImageUrl(imageObjectURL);
//     } catch (error) {
//       console.error("Failed to fetch image:", error);
//     }
//   };

  return (
    <>
      <div className="product-preview-container">
        <ul>
          <li>
            <img className="product-image" src={imageUrl} alt="" />
          </li>
          <li>
            代碼: <span>{code}</span>
          </li>
          <li>
            名稱: <span>{name}</span>
          </li>
          <li>
            售價: <span>{listPrice}</span>
          </li>
          <li>
            特價: <span>{salesPrice}</span>
          </li>
          <li>
            庫存: <span>{quantity}</span>
          </li>
          <li>
            <PurchaseButton code={code} />
          </li>
        </ul>
      </div>
    </>
  );
};

export default ProductItem;
