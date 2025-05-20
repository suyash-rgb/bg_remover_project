import React from 'react';
import { useState } from 'react';

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
    </nav>
  )
}

export default Menubar;