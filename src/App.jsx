import Footer from "./components/Footer";
import Menubar from "./components/Menubar";
import Home from "./pages/Home";
import { BrowserRouter } from "react-router-dom";
import { Route, Routes } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import UserSyncHandler from "./components/UserSyncHandler";
import { RedirectToSignIn, SignedIn } from "@clerk/clerk-react";
import BuyCredits from "./pages/BuyCredits";

const App = () => {
  return (
    <div>
      <UserSyncHandler />
      <Menubar />
      <Toaster />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/pricing" element={<BuyCredits />} />
        <Route path="/result" element={
          <>
            <SignedIn>
              <Result />
            </SignedIn>
            <SignedOut>
              <RedirectToSignIn />
            </SignedOut>
          </>
        }
        />


      </Routes>
      <Footer />

    </div>
  )
}

export default App; 