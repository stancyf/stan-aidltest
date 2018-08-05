// IBookManager.aidl
package com.example.stan.aidlandobserver;

import com.example.stan.aidlandobserver.Book;
import com.example.stan.aidlandobserver.IOnNewBookArrivedListener;
interface IBookManager {
   List<Book> getBookList();
   void addBook(in Book book);
   void registerListener(IOnNewBookArrivedListener listener);
   void unregisterListener(IOnNewBookArrivedListener listener);
}
