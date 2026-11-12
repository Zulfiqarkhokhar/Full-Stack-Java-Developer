import React from "react";
import { useNavigate } from "react-router-dom";
import TaskForm from "../components/tasks/TaskForm";
import axios from "axios";

const AddTask = () => {
  const navigate = useNavigate();

  const handleSubmit = async (newTask) => {
    // Here you would typically add the task to your state/backend
    const res = await axios.post(
      "http://localhost:8080/api/v1/tasks/save",
      newTask,
      {
        auth: {
          username: "user",
          password: "b4bda9b8-a2aa-4fa6-9ae4-cdad2c56624f",
        },
      }
    );
    console.log(res);
    console.log("New task:", newTask);
    // Navigate back to tasks page
    navigate("/tasks");
  };

  const handleCancel = () => {
    navigate("/tasks");
  };

  return (
    <div>
      <h1 className="text-3xl font-bold text-gray-800 mb-8">Add New Task</h1>
      <div className="max-w-2xl">
        <TaskForm onSubmit={handleSubmit} onCancel={handleCancel} />
      </div>
    </div>
  );
};

export default AddTask;
