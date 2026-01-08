import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './auth/LoginPage';
import RegisterPage from './auth/RegisterPage';
import { AuthProvider } from './auth/AuthContext';
import Navbar from './components/Navbar';
import './App.css'
import ProtectedRoute from './auth/ProtectedRoute';
import MentorList from './mentors/MentorList';
import SessionList from './sessions/SessionList';
import SessionsPage from './sessions/SessionsPage';

function App() {
  return (
    <AuthProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/sessions" element={<SessionsPage />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
