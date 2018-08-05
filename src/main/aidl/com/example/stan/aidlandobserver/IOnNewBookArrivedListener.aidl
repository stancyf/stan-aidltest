// IOnNewBookArrivedListener.aidl
package com.example.stan.aidlandobserver;

import com.example.stan.aidlandobserver.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}
