package kders.app.todolist.view.common;


import android.view.View;

public interface IEventListener {
    void onClickBack();

    void showKeyboard(View view);

    void hideKeyboard(View view);

    void showNoNetworkError();

    void onShowDialogError(String message);

    void tokenNotValid();

    void tokenRenew();
}
