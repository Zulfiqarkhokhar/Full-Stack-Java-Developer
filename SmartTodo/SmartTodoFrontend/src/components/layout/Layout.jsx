import React from "react";
import Sidebar from "./SideBar";

const Layout = ({ children, onLogout }) => {
  return (
    <div className="min-h-screen bg-gray-50">
      <Sidebar onLogout={onLogout} />
      <div className="ml-64 p-8">
        <div className="max-w-7xl mx-auto">{children}</div>
      </div>
    </div>
  );
};

export default Layout;
