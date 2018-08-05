package com.example.stan.aidlandobserver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Stan on 2018/8/5.
 */

public class BookManagerService extends Service {

    private static final String TAG = "BookManagerService";

    private AtomicBoolean mIsServiceDetoryed = new AtomicBoolean(false);

    private CopyOnWriteArrayList<IOnNewBookArrivedListener> mListenerList = new CopyOnWriteArrayList<IOnNewBookArrivedListener>();
    private CopyOnWriteArrayList<Book> mBooksList = new CopyOnWriteArrayList<Book>();

    private Binder mBinder = new IBookManager.Stub(){

        @Override
        public IBinder asBinder() {
            return super.asBinder();
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBooksList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBooksList.add(book);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if(!mListenerList.contains(listener)){
                mListenerList.add(listener);
            }else {
                Log.d(TAG, "already exists");
            }
            Log.d(TAG, "registerListener, size:" + mListenerList.size());
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if(mListenerList.contains(listener)){
                mListenerList.remove(listener);
                Log.d(TAG, "unregisterListener: success");
            }else {
                Log.d(TAG, "not found, can not unregisted");
            }
            Log.d(TAG, "unregisterListener, current size " + mListenerList.size());
        }

    };


    @Override
    public void onCreate() {
        super.onCreate();
        mBooksList.add(new Book(1, "Android"));
        mBooksList.add(new Book(2, "IOS"));
        new Thread(new ServiceWorker()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {
        mIsServiceDetoryed.set(true);
        super.onDestroy();
    }

    private void onNewBookArrived(Book book)throws RemoteException{
        mBooksList.add(book);
        Log.d(TAG, "OnNewBookArrived: notify listener:" + mListenerList.size());
        for(int i = 0; i < mListenerList.size(); i++){
            IOnNewBookArrivedListener listener = mListenerList.get(i);
            Log.d(TAG, "OnNewBookArrived: notify listener" + listener);
            listener.onNewBookArrived(book);
        }
    }

    private class ServiceWorker implements Runnable{

        @Override
        public void run() {
            while(!mIsServiceDetoryed.get()){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int bookId = mBooksList.size() + 1;
                Book newBook = new Book(bookId, "new Book#" + bookId);
                try {
                    onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
