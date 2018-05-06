package com.mmfront.base;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by My on 2018/5/1.
 */

public class BasePresenter<T extends BaseView> {
    protected WeakReference<T> mView;
    protected BaseModel mModel = new BaseModel();
    protected Context mContext;

    public BasePresenter(T view) {
        mView = new WeakReference<>(view);
    }

    public T getView() {
        return mView.get();
    }

    //释放view及model的内存空间
    public void onDestroy() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        if (mModel != null) {
            mModel = null;
        }
    }
}
