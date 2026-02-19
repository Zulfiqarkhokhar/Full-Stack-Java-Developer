import React, { memo } from "react";

const Child = memo(function Child({ onClick }) {
  console.log("Child Rendered");
  return (
    <div>
      <button onClick={onClick}>Click Me</button>
    </div>
  );
});

export default Child;
