package com.mmfront.common.disposable;

import io.reactivex.disposables.Disposable;

/**
 * Created by My on 2018/5/1.
 */

public interface DisposableHelper<T> {
    void add(Disposable disposable);
    void cancel(Disposable disposable);
    void cancelAll();
}
