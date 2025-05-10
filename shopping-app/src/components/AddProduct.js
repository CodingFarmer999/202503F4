import React from "react";
import { useState } from "react";
import axios from "axios";

const AddProduct = () => {
  const [formData, setFormData] = useState({
    code: "",
    name: "",
    listPrice: 0,
    salesPrice: 0,
    descript: "",
    online: "0",
    quantity: 0,
    uploadFile: null,
  });

  const handleFormChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleFileChange = (event) => {
    setFormData((prevData) => ({
      ...prevData,
      uploadFile: event.target.files[0],
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = new FormData();
    for (const key in formData) {
      data.append(key, formData[key]);
    }

    try {
      const response = await axios.post("http://localhost:8085/product", data, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      console.log("File uploaded successfully", response.data);
    } catch (error) {
      console.error("Error uploading file", error);
    }
  };

  return (
    <>
      <div className="page-title">商品</div>

      <form onSubmit={handleSubmit}>
        <table style={{ textAlign: "left" }}>
          <tbody>
            <tr>
              <td width={200}>產品代碼：</td>
              <td>
                <input name="code" onChange={handleFormChange} />
              </td>
            </tr>
            <tr>
              <td>產品名稱：</td>
              <td>
                <input name="name" onChange={handleFormChange} />
              </td>
            </tr>
            <tr>
              <td>定價：</td>
              <td>
                <input name="listPrice" onChange={handleFormChange} />
              </td>
            </tr>
            <tr>
              <td>特價：</td>
              <td>
                <input name="salesPrice" onChange={handleFormChange} />
              </td>
            </tr>
            <tr>
              <td>商品描述：</td>
              <td>
                <textarea
                  name="descript"
                  value={formData.descript}
                  onChange={handleFormChange}
                />
              </td>
            </tr>

            <tr>
              <td>上下架：</td>
              <td>
                <label>
                  <input
                    type="radio"
                    name="online"
                    value="1"
                    checked={formData.online === "1"}
                    onChange={handleFormChange}
                  />
                  上架
                </label>
                <label>
                  <input
                    type="radio"
                    name="online"
                    value="0"
                    checked={formData.online === "0"}
                    onChange={handleFormChange}
                  />
                  下架
                </label>
              </td>
            </tr>

            <tr>
              <td>數量：</td>
              <td>
                <input name="quantity" onChange={handleFormChange} />
              </td>
            </tr>
            <tr>
              <td>圖檔上傳</td>

              <td>
                <input type="file" onChange={handleFileChange} />
              </td>
              <td> </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>
                <button type="submit">新增商品</button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </>
  );
};

export default AddProduct;
