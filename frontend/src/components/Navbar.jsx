import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext';

export default function Navbar() {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = async () => {
    await logout();
    navigate('/login');
  };

  return (
    <nav style={{ padding: '10px', borderBottom: '1px solid #ccc' }}>
      <Link to="/">Home</Link> {' | '}
      {user ? (
        <>
          <Link to="/sessions">Sessions</Link> {' | '}
          <Link to="/mentors">Mentors</Link> {' | '}
          <Link to="/profile">Profile</Link> {' | '}
          <button onClick={handleLogout}>Logout</button>
        </>
      ) : (
        <>
          <Link to="/login">Login</Link> {' | '}
          <Link to="/register">Register</Link>
        </>
      )}
    </nav>
  );
}
