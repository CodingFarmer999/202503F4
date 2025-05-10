import React, {useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import UserContext from '../context/UserContext';
import { request } from '../utils/AxiosUtils';

const Header = () => {
    // 取得UserContext.Provider所提供的user，使用useContext可以不用將user當作props傳遞
    const userContext = useContext(UserContext);
    const {user, setUser}  = userContext;
    console.log('userContext', userContext);

    const navigate = useNavigate();

    /**
     * 導頁共用方法
     * @param {*} router 
     */
    const changeRoute = (router) => {
        navigate(router);
    }

    /**
     * 登出
     */
    const logoutHandler = () => {
        // 呼叫後端登出作業
        request(
            "POST",
            "logout"
        ).then((response) => {
            console.log('Logout', response.data);
            // 將使用者狀態清空，並導頁至登入頁
            setUser(null);
            navigate('/login');
        }).catch((error) => {
            console.log("error", error.response.data);
        });
    }
    return (
        <div className="header-container">
            <div className="site-name">線上購物</div>
            <div className="header-bar">
                    Hello <span>{user && user.username}</span>
                    &nbsp;|&nbsp;
                    {
                        user ? <a onClick={() => logoutHandler()}>登出</a> : <a onClick={() => changeRoute("/login")}>登入</a>
                    }
            </div>
        </div>
    );
}

export default Header;
