import React, { useMemo } from "react";

const Users = ({ list }) => {
  console.log("User Component Rendered");
  //   const sorted = list.sort((a, b) => a.localeCompare(b));

  // now only when list changes then the computation will re-occure
  const sorted = useMemo(() => {
    console.log("sorting expensive list");
    return [...list].sort((a, b) => a.localeCompare(b));
  }, [list]);

  return (
    <div>
      <h2>Sorted Users</h2>
      {sorted.map((user, index) => {
        return <div key={index}>{user}</div>;
      })}
    </div>
  );
};

export default Users;
