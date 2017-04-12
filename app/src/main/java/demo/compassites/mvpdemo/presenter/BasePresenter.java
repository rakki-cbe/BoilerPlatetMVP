package demo.compassites.mvpdemo.presenter;

import demo.compassites.mvpdemo.presenter.interfaces.Presenter;
import demo.compassites.mvpdemo.view.interfaces.BaseView;

/**
 * Created by radhakrishanan on 7/4/17.
 */

class BasePresenter<T extends BaseView> implements Presenter<T> {
    private T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    boolean isViewAttached() {
        return mMvpView != null;
    }

    T getBaseView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(baseView) before" +
                    " requesting data to the Presenter");
        }
    }
}
