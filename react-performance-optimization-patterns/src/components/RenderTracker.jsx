import React, { useRef, memo } from "react";

const MemoizedValueTracker = memo(function RenderTracker() {
  const render = useRef(0);
  render.current++;

  return (
    <div>
      <h2>Render Tracker: {render.current}</h2>
    </div>
  );
});

export default MemoizedValueTracker;
