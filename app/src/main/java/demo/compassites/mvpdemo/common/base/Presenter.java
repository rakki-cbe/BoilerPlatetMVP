package demo.compassites.mvpdemo.common.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
interface Presenter<V extends BaseView> {

    void attachView(V baseView);

    void detachView();
}
