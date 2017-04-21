package demo.compassites.mvpdemo.common.base;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class BasePresenter<T extends BaseView> implements Presenter<T> {
    private T mvpView;

    @Override
    public void attachView(T mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    protected boolean isViewAttached() {
        return mvpView != null;
    }

    public T getBaseView() {
        return mvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new CustomException.MvpViewNotAttachedException();
    }


}
