// Cart.js
import React from "react";
import { useCart } from "./App";

const Cart = () => {
  const { cart, removeFromCart } = useCart();

  return (
    <div>
      <h2>Cart</h2>
      {cart.length === 0 ? (
        <p>Cart is empty</p>
      ) : (
        cart.map(item => (
          <div key={item.id}>
            <p>{item.name} - ${item.price}</p>
            <button onClick={() => removeFromCart(item)}>Remove</button>
          </div>
        ))
      )}
      <p>Total: ${cart.reduce((total, item) => total + item.price, 0)}</p>
    </div>
  );
};

export default Cart;
