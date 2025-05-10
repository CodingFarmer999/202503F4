import React from 'react';

const OrderList = () => {
    return (
        <>
            <div className="page-title">訂單列表</div>
            <div>訂單總金額: <span>9999</span></div>
            <table border="1" style={{width: "100%"}}>
                <thead>
                    <tr>
                        <th>訂單編號</th>
                        <th>訂單日期</th>
                        <th>顧客姓名</th>
                        <th>顧客地址</th>
                        <th>顧客Email</th>
                        <th>訂單金額</th>
                        <th>View</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>orderNum</td>
                        <td>orderDate</td>
                        <td>customerName</td>
                        <td>customerAddress</td>
                        <td>customerEmail</td>
                        <td style={{color: "red"}}>amount
                        </td>
                        <td><a>View</a></td>
                    </tr>

                    <tr>
                        <td>orderNum</td>
                        <td>orderDate</td>
                        <td>customerName</td>
                        <td>customerAddress</td>
                        <td>customerEmail</td>
                        <td style={{color: "red"}}>amount
                        </td>
                        <td><a>View</a></td>
                    </tr>

                    <tr>
                        <td>orderNum</td>
                        <td>orderDate</td>
                        <td>customerName</td>
                        <td>customerAddress</td>
                        <td>customerEmail</td>
                        <td style={{color: "red"}}>amount
                        </td>
                        <td><a>View</a></td>
                    </tr>

                </tbody>

            </table>
            <div className="page-navigator">
            </div>
        </>
    );
}

export default OrderList;
