import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
  useNavigate,
} from "react-router-dom";
import Layout from "./components/layout/Layout";
import Tasks from "./pages/Tasks";
import Profile from "./pages/Profile";
import AddTask from "./pages/AddTask";
import Login from "./pages/Login";
import Signup from "./pages/Signup";

// Create a wrapper component to handle navigation
function AppRoutes({ isAuthenticated, user, onLogin, onSignup, onLogout }) {
  return (
    <Routes>
      {/* Public Routes */}
      <Route
        path="/login"
        element={
          isAuthenticated ? (
            <Navigate to="/tasks" replace />
          ) : (
            <Login onLogin={onLogin} />
          )
        }
      />
      <Route
        path="/signup"
        element={
          isAuthenticated ? (
            <Navigate to="/tasks" replace />
          ) : (
            <Signup onSignup={onSignup} />
          )
        }
      />

      {/* Protected Routes */}
      <Route
        path="/*"
        element={
          isAuthenticated ? (
            <Layout onLogout={onLogout}>
              <Routes>
                <Route path="/" element={<Navigate to="/tasks" replace />} />
                <Route path="/tasks" element={<Tasks />} />
                <Route path="/profile" element={<Profile />} />
                <Route path="/add-task" element={<AddTask />} />
              </Routes>
            </Layout>
          ) : (
            <Navigate to="/login" replace />
          )
        }
      />
    </Routes>
  );
}

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Check if user is logged in on app load
    const checkAuth = () => {
      const storedUser = localStorage.getItem("user");
      if (storedUser) {
        setUser(JSON.parse(storedUser));
        setIsAuthenticated(true);
      }
      setLoading(false);
    };

    checkAuth();
  }, []);

  const handleLogin = (userData) => {
    setUser(userData);
    setIsAuthenticated(true);
    // Store in localStorage
    localStorage.setItem("user", JSON.stringify(userData));
  };

  const handleSignup = (userData) => {
    setUser(userData);
    setIsAuthenticated(true);
    // Store in localStorage
    localStorage.setItem("user", JSON.stringify(userData));
  };

  const handleLogout = () => {
    // Clear all auth data
    setUser(null);
    setIsAuthenticated(false);
    localStorage.removeItem("user");
    localStorage.removeItem("token"); // Clear any other auth data
  };

  // Show loading state while checking authentication
  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-center">
          <div className="w-16 h-16 border-4 border-blue-500 border-t-transparent rounded-full animate-spin mx-auto"></div>
          <p className="mt-4 text-gray-600">Loading...</p>
        </div>
      </div>
    );
  }

  return (
    <Router>
      <AppRoutes
        isAuthenticated={isAuthenticated}
        user={user}
        onLogin={handleLogin}
        onSignup={handleSignup}
        onLogout={handleLogout}
      />
    </Router>
  );
}

export default App;
