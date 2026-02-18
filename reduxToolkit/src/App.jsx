import { useState } from "react";
import "./App.css";
import AddTodo from "./components/addTodo";
import Todos from "./components/Todos";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="todo-app">
      <h5>Learn About React ReduxToolKit</h5>
      <AddTodo />
      <Todos />
    </div>
  );
}

export default App;
