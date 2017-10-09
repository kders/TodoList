package kders.app.todolist.view.common;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import kders.app.todolist.AppConstants;
import kders.app.todolist.R;
import kders.app.todolist.common.log.AppLog;


public abstract class BaseFragmentActivity extends AppCompatActivity implements IPopupDialogListener {


    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    private ProgressDialog mProgressDialog;

    protected void onShowLoading() {
        if (mProgressDialog == null)
            mProgressDialog = ProgressDialog.show(this, "", getString(R.string.loading));
        mProgressDialog.show();
    }

    protected void onHideLoading() {
        if (mProgressDialog == null)
            return;
        mProgressDialog.dismiss();
    }

    public void onShowKeyBoard(View view) {
        AppLog.d(AppConstants.TAG, "showKeyBoard");
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void onHideKeyBoard(View view) {
        AppLog.d(AppConstants.TAG, "onHideKeyBoard");
        View currentFocus = getCurrentFocus();
        if (currentFocus == null)
            currentFocus = view;
        currentFocus.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }


    @Override
    public void clickPositiveText(int requestCode) {
        clickDialogPositiveText(requestCode);
    }

    @Override
    public void clickNegativeText(int requestCode) {
        clickDialogNegativeText(requestCode);
    }

    public abstract void clickDialogPositiveText(int requestCode);

    public abstract void clickDialogNegativeText(int requestCode);


}
