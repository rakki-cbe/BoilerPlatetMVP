package demo.compassites.mvpdemo.presenter.interfaces;

import demo.compassites.mvpdemo.view.interfaces.BaseView;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface Presenter<V extends BaseView> {

    void attachView(V baseView);

    void detachView();
}
