import React, { useState } from 'react';
import { HashRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './Header';
import Menu from './Menu';
import Home from './Home';
import ProductList from './ProductList';
import Footer from './Footer';
import Login from './Login';
import OrderList from './OrderList';
import ShoppingCart from './ShoppingCart';

import UserContext from '../context/UserContext';
import Customer from './Customer';
import ShippingCartConfirm from './ShippingCartConfirm';
import AddProduct from './AddProduct';

import 'bootstrap/dist/css/bootstrap.min.css';
import CheckoutConfirm from './CheckoutConfirm';

const App = () => {

    const [user, setUser] = useState(null);

    return (
        <UserContext.Provider value={{user, setUser}}>
            <Router>
                <Header user={user}/>
                <Menu user={user}/>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/login" element={<Login user={user} setUser={setUser} />} />
                    <Route path="/productList" element={<ProductList />} />
                    <Route path="/shoppingCart" element={<ShoppingCart />} />
                    <Route path="/orderList" element={<OrderList />} />
                    <Route path="/customer" element={<Customer />} />
                    <Route path="/checkoutConfirm" element={<CheckoutConfirm />} />
                    <Route path='/shippingCartConfirm' element={<ShippingCartConfirm />} />
                    <Route path="/addProduct" element={<AddProduct />} />

                </Routes>
                <Footer />
            </Router>
        </UserContext.Provider>
    );
}

export default App;
