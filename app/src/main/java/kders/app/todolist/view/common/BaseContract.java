package kders.app.todolist.view.common;


public interface BaseContract {
    interface View{
        void showLoading();
        void hideLoading();
        void showError(String errorMessage);
        void showDialogError(String errorMessage);
        void tokenNotValid();
        void tokenRenew();
    }

    interface Presenter<T extends  View>{
        void bindView(T view);
        void release();
    }
}
