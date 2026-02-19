import React, { useState } from "react";
import { getUsers } from "../../utils/getUsers";
import Users from "./Users";

const UserSortingDemo = () => {
  const [count, setCount] = useState(0);
  const [users] = useState(() => getUsers());

  return (
    <div>
      <p>{count}</p>
      <button onClick={() => setCount((c) => c + 1)}>Increment</button>
      <Users list={users} />
    </div>
  );
};

export default UserSortingDemo;
