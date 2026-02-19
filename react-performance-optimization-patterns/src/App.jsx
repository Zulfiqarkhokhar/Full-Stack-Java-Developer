import { useState } from "react";
import "./App.css";
import RenderTrackerDemo from "./components/memoization/RenderTrackerDemo";
import ChildDemo from "./components/memoization/ChildDemo";
import UserSortingDemo from "./components/memoization/UserSortingDemo";

function App() {
  return (
    <>
      {/* <RenderTrackerDemo /> */}
      {/* <ChildDemo /> */}
      <UserSortingDemo />
    </>
  );
}

export default App;
