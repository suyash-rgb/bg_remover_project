// Import assets
import logo from './logo.png';
import video_banner from './video_banner.mp4';
import slide_icon from './slide_icon.png';

// Import category images
import people_with_bg from './people_with_bg.png';
import people_without_bg from './people_without_bg.png';

import animals_with_bg from './animals_with_bg.png';
import animals_without_bg from './animals_without_bg.png';

import products_with_bg from './products_with_bg.png';
import products_without_bg from './products_without_bg.png';

import cars_with_bg from './cars_with_bg.jpg'; // Verified JPG format
import cars_without_bg from './cars_without_bg.png';

import graphics_with_bg from './graphics_with_bg.png';
import graphics_without_bg from './graphics_without_bg.png';

import credits from './credits.png';

// Export assets
export const assets = {
   logo,
   video_banner,
   slide_icon,
   people_with_bg,
   people_without_bg,
   animals_with_bg,
   animals_without_bg,
   products_with_bg,
   products_without_bg,
   cars_with_bg, // JPG format retained
   cars_without_bg,
   graphics_with_bg,
   graphics_without_bg,
   credits,
};

// Export categories with correct image references
export const categories = {
  People: {
    with_bg: people_with_bg,
    without_bg: people_without_bg,
  },
  Animals: {
    with_bg: animals_with_bg,
    without_bg: animals_without_bg,
  },
  Products: {
    with_bg: products_with_bg,
    without_bg: products_without_bg,
  },
  Cars: {
    with_bg: cars_with_bg, // JPG format retained
    without_bg: cars_without_bg,
  },
  Graphics: {
    with_bg: graphics_with_bg,
    without_bg: graphics_without_bg,
  },
};

// Other exports remain unchanged
export const steps = [
   {
      step: "Step 1",
      title: "Select an image",
      description: "First, choose the image you want to remove background from by clicking on 'Start' from a photo.\nYour image format can be PNG or JPG.\nWe support all image dimensions."
   },
   {
      step: "Step 2",
      title: "Let AI do its magic",
      description: "Our tool automatically removes the background from your image. Next you can choose a background color.\nOur most popular options are white and transparent backgrounds, but you can pick any color you like."
   },
   {
      step: "Step 3",
      title: "Download your image",
      description: "After selecting a new background color, download your photo and you're done.\nYou can also save your picture in the Photoroom App by creating an account."
   }
];

export const plans = [
  {
    id: "Basic",
    name: "Basic Package",
    price: 499,
    credits: "100 credits",
    description: "Best for personal use",
    popular: false
  },
  {
    id: "Premium",
    name: "Premium Package",
    price: 899,
    credits: "250 credits",
    description: "Best for business use",
    popular: true
  },
  {
    id: "Ultimate",
    name: "Ultimate Package",
    price: 1499,
    credits: "1000 credits",
    description: "Best for enterprise use",
    popular: false
  }
];

export const testimonials = [
  {
    id: 1,
    quote: "We are impressed by the AI and think it's the best choice on the market.",
    author: "Anthony Walker",
    handle: "@_webarchitect_"
  },
  {
    id: 2,
    quote: "remove.bg is leaps and bounds ahead of the competition. A thousand times better. It simplified the whole process.",
    author: "Sarah Johnson",
    handle: "@techlead_sarah"
  },
  {
    id: 3,
    quote: "We were impressed by its ability to account for pesky, feathery hair without making an image look jagged and amateurish.",
    author: "Michael Chen",
    handle: "@coding_newbie"
  }
];

export const FOOTER_CONSTANTS = [
  {
    url: "https://facebook.com",
    logo: "https://img.icons8.com/fluent/30/000000/facebook-new.png"
  },
  {
    url: "https://www.linkedin.com/in/suyash-baoney-bb38b3290",
    logo: "https://img.icons8.com/fluent/30/000000/linkedin-2.png"
  },
  {
    url: "https://instagram.com",
    logo: "https://img.icons8.com/fluent/30/000000/instagram-new.png"
  },
  {
    url: "https://twitter.com",
    logo: "https://img.icons8.com/fluent/30/000000/twitter.png"
  }
];