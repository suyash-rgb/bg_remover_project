import React from 'react';
import { assets } from '../assets/assets';
import { FOOTER_CONSTANTS } from '../assets/assets';

const Footer = () => {
  return (
    <footer className="flex justify-between items-center w-full px-8 py-6 bg-white text-gray-500">
      {/* Logo & Copyright */}
      <div className="flex items-center gap-2">
        <img src={assets.logo} alt="logo" width={32} />
        <p className="text-sm">
          &copy; {new Date().getFullYear()} suyashbaoney58@gmail.com | All rights reserved.
        </p>
      </div>

      {/* Social Links on the Right */}
      <div className="flex gap-3 items-end">
        {FOOTER_CONSTANTS.map(({ url, logo }, index) => (
          <a key={index} href={url} target="_blank" rel="noopener noreferrer">
            <img src={logo} alt="social-icon" width={32} />
          </a>
        ))}
      </div>
    </footer>
  );
};

export default Footer;