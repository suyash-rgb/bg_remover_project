import axios from "axios";
import toast from "react-hot-toast";

export const placeholder = async ({ planId, getToken, onSuccess, backendUrl }) => {
    try {
        const token = await getToken();
        const response = await axios.post(`${backendUrl}/orders?planId=${planId}`,
            {}, { headers: { Authorization: `Bearer ${token}` } });
        if (response.status === 200) {
            intializePayment({ order: response.data.data, getToken, onSuccess, backendUrl });
        }
    } catch (error) {
        toast.error(error.message);
    }
}

const intializePayment = ({ order, getToken, onSuccess, backendUrl }) => {
    const options = {
        key: import.meta.env.VITE_RAZORPAY_KEY_ID,
        amount: order.amount,
        currency: order.currency,
        name: "Credit Payment",
        description: "Credit Payment",
        order_id: order.id,
        receipt: order.receipt,
        handler: async (paymentDetails) => {
            try {
                const token = await getToken();
                const response = await axios.post(`${backendUrl}/orders/verify`, paymentDetails,
                    { headers: { Authorization: `Bearer ${token}` } });
                if (response.status === 200) {
                    toast.success("Credits added.");
                    onSuccess?.();
                } else {
                    toast.error(response.data.message);
                }
            } catch (error) {
                toast.error(error.message);
            }
        }
    }
    const rzp = new window.Razorpay(options);
    rzp.open();
}