import React, { useState } from "react";
import Button from "../common/Button";
import TaskForm from "./TaskForm";
import {
  FaCalendarAlt,
  FaCheckCircle,
  FaClock,
  FaExclamationCircle,
} from "react-icons/fa";

const TaskCard = ({ task, onDelete, onUpdate, onToggleComplete }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [showConfirmDialog, setShowConfirmDialog] = useState(false);

  const priorityColors = {
    LOW: "bg-green-100 text-green-800 border-green-200",
    MEDIUM: "bg-yellow-100 text-yellow-800 border-yellow-200",
    HIGH: "bg-red-100 text-red-800 border-red-200",
  };

  const priorityIcons = {
    LOW: <FaClock className="w-3 h-3 mr-1" />,
    MEDIUM: <FaExclamationCircle className="w-3 h-3 mr-1" />,
    HIGH: <FaExclamationCircle className="w-3 h-3 mr-1" />,
  };

  const getDueDateStatus = () => {
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    const dueDate = new Date(task.dueDate);
    dueDate.setHours(0, 0, 0, 0);

    if (task.completed)
      return { text: "Completed", color: "text-green-600", bg: "bg-green-50" };
    if (dueDate < today)
      return { text: "Overdue", color: "text-red-600", bg: "bg-red-50" };
    if (dueDate.getTime() === today.getTime())
      return {
        text: "Due Today",
        color: "text-orange-600",
        bg: "bg-orange-50",
      };

    const diffTime = dueDate - today;
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    return {
      text: `${diffDays} day${diffDays > 1 ? "s" : ""} left`,
      color: "text-blue-600",
      bg: "bg-blue-50",
    };
  };

  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "short", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };

  const dueDateStatus = getDueDateStatus();

  const handleDelete = () => {
    setShowConfirmDialog(true);
  };

  const confirmDelete = () => {
    onDelete(task.id);
    setShowConfirmDialog(false);
  };

  if (isEditing) {
    return (
      <TaskForm
        task={task}
        onSubmit={(updatedTask) => {
          onUpdate({ ...task, ...updatedTask });
          setIsEditing(false);
        }}
        onCancel={() => setIsEditing(false)}
      />
    );
  }

  return (
    <>
      <div
        className={`bg-white rounded-lg shadow-md p-6 relative border-l-4 transition-all hover:shadow-lg ${
          task.completed
            ? "border-l-green-500 opacity-75"
            : dueDateStatus.text === "Overdue"
            ? "border-l-red-500"
            : "border-l-blue-500"
        }`}
      >
        {/* Priority Chip - Moved to top left */}
        <div className="flex items-center justify-between mb-4">
          <span
            className={`inline-flex items-center px-3 py-1 rounded-full text-xs font-semibold border ${
              priorityColors[task.priority]
            }`}
          >
            {priorityIcons[task.priority]}
            {task.priority}
          </span>

          {/* Completion Status Badge */}
          <span
            className={`inline-flex items-center px-3 py-1 rounded-full text-xs font-semibold ${
              task.completed
                ? "bg-green-100 text-green-800 border-green-200"
                : "bg-gray-100 text-gray-800 border-gray-200"
            }`}
          >
            {task.completed ? (
              <>
                <FaCheckCircle className="w-3 h-3 mr-1" />
                Completed
              </>
            ) : (
              "Pending"
            )}
          </span>
        </div>

        {/* Title and Description */}
        <div className="mb-4">
          <h3
            className={`text-lg font-semibold mb-2 ${
              task.completed ? "line-through text-gray-400" : "text-gray-800"
            }`}
          >
            {task.title}
          </h3>
          <p
            className={`text-sm ${
              task.completed ? "text-gray-400" : "text-gray-600"
            }`}
          >
            {task.description}
          </p>
        </div>

        {/* Due Date Section */}
        <div
          className={`flex items-center justify-between p-3 rounded-lg mb-4 ${dueDateStatus.bg}`}
        >
          <div className="flex items-center text-sm">
            <FaCalendarAlt className={`mr-2 ${dueDateStatus.color}`} />
            <span className="font-medium text-gray-700">Due:</span>
            <span className="ml-2 text-gray-600">
              {formatDate(task.dueDate)}
            </span>
          </div>
          <span className={`text-xs font-semibold ${dueDateStatus.color}`}>
            {dueDateStatus.text}
          </span>
        </div>

        {/* Action Buttons */}
        <div className="flex justify-between items-center">
          {/* Mark Complete/Incomplete Button */}
          {!task.completed ? (
            <Button
              variant="success"
              onClick={() => onToggleComplete(task.id)}
              className="text-sm flex items-center"
            >
              <FaCheckCircle className="mr-2" />
              Mark Complete
            </Button>
          ) : (
            <Button
              variant="secondary"
              onClick={() => onToggleComplete(task.id)}
              className="text-sm"
            >
              Mark Pending
            </Button>
          )}

          {/* Edit and Delete Buttons */}
          <div className="flex space-x-2">
            <Button
              variant="secondary"
              onClick={() => setIsEditing(true)}
              className="text-sm px-4"
            >
              Edit
            </Button>
            <Button
              variant="danger"
              onClick={handleDelete}
              className="text-sm px-4"
            >
              Delete
            </Button>
          </div>
        </div>
      </div>

      {/* Delete Confirmation Dialog */}
      {showConfirmDialog && (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
          <div className="bg-white rounded-lg p-6 max-w-sm mx-4">
            <h3 className="text-lg font-semibold text-gray-800 mb-4">
              Confirm Delete
            </h3>
            <p className="text-gray-600 mb-6">
              Are you sure you want to delete this task? This action cannot be
              undone.
            </p>
            <div className="flex justify-end space-x-3">
              <Button
                variant="secondary"
                onClick={() => setShowConfirmDialog(false)}
              >
                Cancel
              </Button>
              <Button variant="danger" onClick={confirmDelete}>
                Delete
              </Button>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default TaskCard;
