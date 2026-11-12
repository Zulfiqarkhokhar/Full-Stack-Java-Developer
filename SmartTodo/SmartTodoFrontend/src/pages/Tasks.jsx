import React, { useEffect, useState } from "react";
import TaskList from "../components/tasks/TaskList";
import axios from "axios";

const Tasks = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    const getTasks = async () => {
      const res = await axios.get("http://localhost:8080/api/v1/tasks", {
        auth: {
          username: "user",
          password: "b4bda9b8-a2aa-4fa6-9ae4-cdad2c56624f",
        },
      });
      console.log(res);
      setTasks(res.data);
    };
    getTasks();
  }, []);

  const handleDelete = (taskId) => {
    setTasks(tasks.filter((task) => task.id !== taskId));
  };

  const handleUpdate = (updatedTask) => {
    setTasks(
      tasks.map((task) => (task.id === updatedTask.id ? updatedTask : task))
    );
  };

  const handleToggleComplete = (taskId) => {
    setTasks(
      tasks.map((task) =>
        task.id === taskId ? { ...task, completed: !task.completed } : task
      )
    );
  };

  return (
    <div>
      <h1 className="text-3xl font-bold text-gray-800 mb-8">My Tasks</h1>
      <TaskList
        tasks={tasks}
        onDelete={handleDelete}
        onUpdate={handleUpdate}
        onToggleComplete={handleToggleComplete}
      />
    </div>
  );
};

export default Tasks;
