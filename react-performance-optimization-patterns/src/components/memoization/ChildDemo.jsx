import React, { useCallback, useState } from "react";
import Child from "./Child";

const ChildDemo = () => {
  const [count, setCount] = useState(0);

  console.log("App Rendered");

  const handleClick = useCallback(() => {
    console.log("Clicked");
  }, []);

  return (
    <div>
      <p>Count: {count}</p>
      <div>
        <button onClick={() => setCount(count + 1)}>Increment</button>

        {/* new reference everytime parent re-render for the passed function */}
        {/* <Child onClick={() => console.log("clicked")} /> */}

        <Child onClick={handleClick} />
      </div>
    </div>
  );
};

export default ChildDemo;
