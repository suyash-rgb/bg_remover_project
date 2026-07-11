import { useState, useEffect, useContext } from "react";
import { AppContext } from "../context/AppContext";
import { useAuth, useUser } from "@clerk/clerk-react";
import axios from "axios";
import toast from "react-hot-toast";

const UserSyncHandler = () => {

    const { isLoaded, isSignedIn, getToken } = useAuth();
    const { user } = useUser();
    const [synced, setSynced] = useState(false);
    const { backendUrl } = useContext(AppContext);

    useEffect(() => {
        const saveUser = async () => {
            if (!isLoaded || !isSignedIn || synced) {
                return;
            }
            try {
                const token = await getToken();
                const userData = {
                    clerkId: user.id,
                    email: user.primaryEmailAddress.emailAddress,
                    firstName: user.firstName,
                    lastName: user.lastName,
                };

                await axios.post(backendUrl + "/api/users", userData, { headers: { "Authorization": `Bearer ${token}` } })
                // if (response.data.success === true) {
                //     console.log("User successfully created!");
                //     toast.success("Account created successfully!");
                // }
                // else {
                //     toast.error("Unable to create account. Please try again. ")
                // }
                setSynced(true); //prevent re-posting
                //TODO: update the user creadits  api call 
            } catch (error) {
                console.error("User sync failed", error);
                toast.error("Unable to create account. Please try again. ")
            }
        }
        saveUser();


    }, [isLoaded, isSignedIn, getToken, user, synced]);

    return null;
}

export default UserSyncHandler;
