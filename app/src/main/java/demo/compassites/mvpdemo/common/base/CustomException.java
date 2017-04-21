package demo.compassites.mvpdemo.common.base;

/**
 * Created by radhakrishnan on 14/4/17.
 */

public class CustomException extends RuntimeException {
    public static class dataNotAttached extends RuntimeException {
        public dataNotAttached() {
            super("Please set data before call apply data");
        }
    }

    static class MvpViewNotAttachedException extends RuntimeException {
        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(baseView) before" +
                    " requesting data to the Presenter");
        }
    }


}
