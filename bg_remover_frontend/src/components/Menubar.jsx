import React from 'react';
import { assets } from '../assets/assets';
import { useState } from 'react';
import { Menu, X } from 'lucide-react';

const Menubar = () => {
  const [menuOpen, setMenuOpen]= useState(false);
  return (
    <nav className="bg-white px-8 py-4 flex justify-between items-center">
       {/* Left side: logo+text*/}
       <div className="flex items-center space-x-2">
            <img src={assets.logo} alt="Logo" className="h-8 w-8 object-contain cursor-pointer" />
            <span className="text-2xl font-semibold text-indigo-700 cursor-pointer">
               remove.<span className="text-gray-400 cursor-pointer">bg </span>
            </span>
       </div>


       {/* Right side: Action buttons */}
       <div className="hidden md:flex items-center space-x-4">
        <button className="text-gray-700 hover:text-blue-500 font-medium">Login</button>
        <button className="bg-gray-100 hover:bg-gray-200 text-gray-700 font-medium px-4 py-2 rounded-full transition-all">Sign up</button>
       </div>

       {/* Hamburger menu for mobile */}
       <div className="flex md:hidden">
        <button onClick={() => setMenuOpen(!menuOpen)}>
          {menuOpen ? <X size={28}/> : <Menu size={28} />}
        </button>
       </div> 

       {/* Mobile menu */}
       {menuOpen && (
        <div className="absolute top-16 right-8 bg-white shadow-md rounded-md flex flex-col space-y-4 p-4 w-40">
          <button className="text-gray-700 hover:text-blue-500 font-medium" onClick={() => setMenuOpen(false)}>
            Login
          </button>
          <button className="bg-gray-100 hover:bg-gray-200 text-gray-700 font-medium px-4 py-2 rounded-full text-center" onClick={() => setMenuOpen(false)}>
            Sign Up
          </button>
        </div>  
      )}

    </nav>
  )
}

export default Menubar;