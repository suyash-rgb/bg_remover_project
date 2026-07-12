import Footer from "./components/Footer";
import Menubar from "./components/Menubar";
import Home from "./pages/Home";
import { BrowserRouter } from "react-router-dom";
import { Route, Routes } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import UserSyncHandler from "./components/UserSyncHandler";
import { RedirectToSignIn, SignedIn } from "@clerk/clerk-react";

const App = () => {
  return (
    <div>
      <UserSyncHandler />
      <Menubar />
      <Toaster />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/result" elemzent={
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