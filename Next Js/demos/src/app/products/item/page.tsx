"use client";
import React from "react";
import { useRouter } from "next/navigation";

const Item = () => {
  const router = useRouter();

  return (
    <div>
      <h1>Nested Route for item</h1>
      <button onClick={() => router.back()}>back</button>
    </div>
  );
};

export default Item;
