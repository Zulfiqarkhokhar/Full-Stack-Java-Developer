"use client";
import Link from "next/link";
import { useRouter } from "next/navigation";
import React from "react";

const page = () => {
  const router = useRouter();

  return (
    <div>
      <Link href={"/about"} className="m-4">
        About Page
      </Link>
      <Link href={"/contact"} className="m-4">
        Contact Page
      </Link>
      <button
        className="btn bg-blue"
        onClick={() => router.push("/products/item")}
      >
        Go to Item Page
      </button>
    </div>
  );
};

export default page;
