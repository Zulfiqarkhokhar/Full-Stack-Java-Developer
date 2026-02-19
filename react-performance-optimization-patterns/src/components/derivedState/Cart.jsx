import React, { useEffect, useState } from "react";

const Cart = ({ items }) => {
  const [total, setTotal] = useState(0);

  useEffect(() => {
    const sum = items.reduce((acc, item) => acc + item.price, 0);
    setTotal(sum);
  }, [items]);

  return (
    <div>
      <h2>Total: {total}</h2>
    </div>
  );
};

export default Cart;
