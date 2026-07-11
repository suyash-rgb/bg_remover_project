import Footer from "./components/Footer";
import Menubar from "./components/Menubar";
import Home from "./pages/Home";
import { BrowserRouter } from "react-router-dom";
import { Route, Routes } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import UserSyncHandler from "./components/UserSyncHandler";

const App = () => {
  return (
    <div>
      <UserSyncHandler />
      <Menubar />
      <Toaster />
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
      <Footer />

    </div>
  )
}

export default App; 