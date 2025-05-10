import React, { useEffect, useState } from 'react';
import ProductItem from './ProductItem';
import { request } from '../utils/AxiosUtils';

const ProductList = () => {
    // 商品列表
    const [productList, setProductList] = useState([]);

    // 分頁資訊
    const [pages, setPages] = useState({});

    // 當前頁面
    const [currentPageNo, setCurrentPageNo] = useState(0);

    useEffect(() => {
        console.log(`invoke api:/products/${currentPageNo}/{pageSize}`);
        let pageSize = 6;

        request(
            "GET",
            `products/${currentPageNo}/${pageSize}`
        ).then(response => {
            let productPage = response.data;
            console.log("productPage:", productPage);
            let content = productPage.content;
            setPages(productPage);
            setCurrentPageNo(productPage.number);
            setProductList(content);
        });

    }, [currentPageNo]);

    // 解構分頁資訊
    const {first, last, number, totalPages} = pages ?? {};

    // 分頁
    let navItems = [];
    for (let index = 0; index < totalPages; index += 1) {
        navItems.push(<a className={`navi-item ${number === index ? "active" : ""}`} key={index} onClick={(event) => changePage(event, index)}>{index + 1}</a>);
    }

    const changePage = (event, pageNo) => {
        // 防止a標籤Route行為
        event.preventDefault();
        // 直接將currentPage設定為指定頁面，當頁App元件useEffect偵測到currentPage改變時，會重新取得資料
        setCurrentPageNo(pageNo)
    }

    return (
        <>
            <div className="page-title">商品列表</div>
            {
                // 商品列表
                productList.map(p => <ProductItem key={p.code} product={p}/>)
            }

            <br />
            {
                totalPages > 1 &&            
                <div className="page-navigator">
                    {navItems}
                </div>
            }
        </>
    );
}

export default ProductList;
