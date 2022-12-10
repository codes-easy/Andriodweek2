package com.example.andriodweek2;

import android.os.Parcel;
import android.os.Parcelable;

public class Donation implements Parcelable {
    double amount;
    int paymentMethod;//0 for paypal and 1 for credit

    public Donation(double amount, int pmt_method) {
        this.amount = amount;
        this.paymentMethod = pmt_method;
    }

    String getDonationInfo(){
        String pmtMethod = (this.paymentMethod == 0 ? "Paypal" : "Credit Card");
        return "The Object amount is" + this.amount + " $ and the payment methtod is " + pmtMethod;
    }

    protected Donation(Parcel in) {
        amount = in.readDouble();
        paymentMethod = in.readInt();
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(amount);
        dest.writeInt(paymentMethod);
    }
}
