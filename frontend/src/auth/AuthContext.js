import { createContext, useContext, useState, useEffect } from 'react';
import axios from '../api/axiosInstance';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);

    useEffect(() => {
        axios.get('/user/profile')
            .then(res => setUser(res.data))
            .catch(() => setUser(null));
    }, []);

    const login = async (credentials) => {
        const res = await axios.post('/auth/login', credentials);
        localStorage.setItem('token', res.data.token); 
        setUser(res.data.user);
    };


    const register = async (credentials) => {
        const res = await axios.post('/auth/register', credentials);
        localStorage.setItem('token', res.data.token); 
        setUser(res.data.user);
    };

    const logout = async () => {
        await axios.post('/auth/logout');
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, register, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
