import React, { useState } from "react";
import Button from "../components/common/Button";
import { FaCamera } from "react-icons/fa";

const Profile = () => {
  const [profileData, setProfileData] = useState({
    fullName: "John Doe",
    email: "john.doe@example.com",
    profileImage: null,
    previewImage: null,
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProfileData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleImageUpload = (e) => {
    const file = e.target.files[0];
    if (file) {
      // Check file type
      if (!file.type.match(/image.*/)) {
        alert("Please upload an image file");
        return;
      }

      // Check file size (max 5MB)
      if (file.size > 5 * 1024 * 1024) {
        alert("File size should be less than 5MB");
        return;
      }

      const reader = new FileReader();
      reader.onloadend = () => {
        setProfileData((prev) => ({
          ...prev,
          profileImage: file,
          previewImage: reader.result,
        }));
      };
      reader.readAsDataURL(file);
    }
  };

  const handleSaveChanges = () => {
    // Here you would typically send the data to your backend
    console.log("Saving profile data:", profileData);
    alert("Profile updated successfully!");
  };

  const getInitials = () => {
    return profileData.fullName
      .split(" ")
      .map((word) => word[0])
      .join("")
      .toUpperCase()
      .slice(0, 2);
  };

  return (
    <div>
      <h1 className="text-3xl font-bold text-gray-800 mb-8">Profile</h1>
      <div className="bg-white rounded-lg shadow-md p-8 max-w-2xl">
        {/* Profile Image Section with Upload */}
        <div className="flex items-center mb-6">
          <div className="relative group">
            {/* Profile Image/Avatar */}
            <div className="w-24 h-24 bg-blue-500 rounded-full flex items-center justify-center overflow-hidden">
              {profileData.previewImage ? (
                <img
                  src={profileData.previewImage}
                  alt="Profile"
                  className="w-full h-full object-cover"
                />
              ) : (
                <span className="text-3xl text-white">{getInitials()}</span>
              )}
            </div>

            {/* Upload Overlay */}
            <label className="absolute inset-0 flex items-center justify-center bg-black bg-opacity-50 rounded-full opacity-0 group-hover:opacity-100 transition-opacity cursor-pointer">
              <FaCamera className="text-white text-xl" />
              <input
                type="file"
                accept="image/*"
                onChange={handleImageUpload}
                className="hidden"
              />
            </label>
          </div>

          <div className="ml-6">
            <h2 className="text-2xl font-semibold text-gray-800">
              {profileData.fullName}
            </h2>
            <p className="text-gray-600">{profileData.email}</p>
            <p className="text-sm text-gray-500 mt-1">
              Click on the camera icon to change profile picture
            </p>
          </div>
        </div>

        {/* Account Settings Form */}
        <div className="border-t border-gray-200 pt-6">
          <h3 className="text-lg font-semibold text-gray-800 mb-4">
            Account Settings
          </h3>
          <div className="space-y-4">
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-2">
                Full Name
              </label>
              <input
                type="text"
                name="fullName"
                value={profileData.fullName}
                onChange={handleInputChange}
                className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            </div>

            <div>
              <label className="block text-sm font-medium text-gray-700 mb-2">
                Email
              </label>
              <input
                type="email"
                name="email"
                value={profileData.email}
                onChange={handleInputChange}
                className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            </div>

            {/* Image Upload Info */}
            {profileData.profileImage && (
              <div className="text-sm text-gray-600">
                Selected: {profileData.profileImage.name}
              </div>
            )}

            {/* Action Buttons */}
            <div className="flex space-x-3 mt-6">
              <Button variant="primary" onClick={handleSaveChanges}>
                Save Changes
              </Button>
              <Button
                variant="secondary"
                onClick={() => {
                  setProfileData((prev) => ({
                    ...prev,
                    profileImage: null,
                    previewImage: null,
                  }));
                }}
              >
                Remove Image
              </Button>
            </div>
          </div>
        </div>

        {/* Additional Info Section */}
        <div className="mt-6 p-4 bg-blue-50 rounded-lg">
          <h4 className="text-sm font-semibold text-blue-800 mb-2">
            Profile Tips
          </h4>
          <ul className="text-sm text-blue-600 space-y-1">
            <li>• Upload a clear photo of yourself</li>
            <li>• Maximum file size: 5MB</li>
            <li>• Supported formats: JPG, PNG, GIF</li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Profile;
