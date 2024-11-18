// App.js
import React, { useState, createContext, useContext } from "react";
import ProductList from "./ProductList";
import Cart from "./Cart";

const CartContext = createContext();

const App = () => {
  const [cart, setCart] = useState([]);

  const addToCart = (product) => setCart([...cart, product]);
  const removeFromCart = (product) => {
    setCart(cart.filter(item => item.id !== product.id));
  };

  return (
    <CartContext.Provider value={{ cart, addToCart, removeFromCart }}>
      <h1>Shopping Cart</h1>
      <ProductList />
      <Cart />
    </CartContext.Provider>
  );
};

export const useCart = () => useContext(CartContext);
export default App;