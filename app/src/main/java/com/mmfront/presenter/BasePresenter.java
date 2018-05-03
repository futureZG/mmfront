package com.mmfront.presenter;

/**
 * Created by My on 2018/5/1.
 */

public class BasePresenter<V> {
    public V view;

    public void addView(V v){
        this.view = v;
    }
    public void deattch(){
        if(view != null){
            view = null;
        }
    }
}
