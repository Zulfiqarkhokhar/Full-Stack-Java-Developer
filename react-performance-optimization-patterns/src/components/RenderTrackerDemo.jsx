import React, { useState } from "react";
import RenderTracker from "./RenderTracker";

const RenderTrackerDemo = () => {
  const [value, setValue] = useState("");

  return (
    <div>
      <RenderTracker />
      <input
        type="text"
        value={value}
        onChange={(e) => setValue(e.target.value)}
      />
    </div>
  );
};

export default RenderTrackerDemo;
