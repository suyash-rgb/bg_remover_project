import { useAuth } from "@clerk/clerk-react";
import { createContext, useState } from "react";

export const AppContext = createContext();

const AppContextProvider = (props) => {

    const backendUrl = import.meta.env.VITE_BACKEND_URL;
    const [credit, setCredit] = useState(false);
    const { getToken } = useAuth();

    const loadUserCredits = async () => {
        try {
            const token = await getToken();
            const response = await axios.get(backendUrl + "/users/credits", { headers: { Authorization: `Bearer ${token}` } });
            if (response.data.success) {
                setCredit(response.data.data.credits);
            } else {
                toast.error("Error loading credits");
            }
        } catch (error) {
            toast.error("Failed to load user credits");
        }
    }

    const contextValue = {
        credit, setCredit,
        loadUserCredits,
        backendUrl
    }

    return (
        <AppContext.Provider value={contextValue}>
            {props.children}
        </AppContext.Provider>
    )
}

export default AppContextProvider;
