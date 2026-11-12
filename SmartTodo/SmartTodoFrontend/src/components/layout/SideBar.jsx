import React from "react";
import { NavLink, useNavigate } from "react-router-dom";
import { FaTasks, FaUser, FaPlusCircle, FaSignOutAlt } from "react-icons/fa";

const Sidebar = ({ onLogout }) => {
  const navigate = useNavigate();

  const navItems = [
    { path: "/tasks", name: "Tasks", icon: <FaTasks className="mr-3" /> },
    { path: "/profile", name: "Profile", icon: <FaUser className="mr-3" /> },
    {
      path: "/add-task",
      name: "Add Task",
      icon: <FaPlusCircle className="mr-3" />,
    },
  ];

  const handleLogout = () => {
    // Clear user data from localStorage
    localStorage.removeItem("user");
    localStorage.removeItem("token"); // Clear any other auth data

    // Call the logout callback if provided
    if (onLogout) {
      onLogout();
    }

    // Force navigate to login page
    navigate("/login", { replace: true });
  };

  return (
    <div className="w-64 bg-white shadow-lg h-screen fixed left-0 top-0 flex flex-col">
      <div className="p-6 flex-1">
        <h1 className="text-2xl font-bold text-blue-600 mb-8">Task Manager</h1>
        <nav className="space-y-2">
          {navItems.map((item) => (
            <NavLink
              key={item.path}
              to={item.path}
              className={({ isActive }) =>
                `flex items-center px-4 py-3 rounded-lg transition-colors duration-200 ${
                  isActive
                    ? "bg-blue-500 text-white"
                    : "text-gray-700 hover:bg-blue-50 hover:text-blue-600"
                }`
              }
            >
              {item.icon}
              <span className="font-medium">{item.name}</span>
            </NavLink>
          ))}
        </nav>
      </div>

      {/* Logout Button at Bottom */}
      <div className="p-6 border-t border-gray-200">
        <button
          onClick={handleLogout}
          className="flex items-center w-full px-4 py-3 text-gray-700 hover:bg-red-50 hover:text-red-600 rounded-lg transition-colors duration-200"
        >
          <FaSignOutAlt className="mr-3" />
          <span className="font-medium">Logout</span>
        </button>
      </div>
    </div>
  );
};

export default Sidebar;
