package kders.app.todolist.view.common;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.widget.Toast;

import kders.app.todolist.R;


public abstract class BaseFragment extends Fragment {

    public BaseFragment(){
    }
    protected void showToast(String message) {
        if (getActivity() == null)
            return;
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String message) {
        if (getActivity() == null)
            return;
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
    protected abstract int getType();

    private ProgressDialog mProgressDialog;

    protected void onShowLoading() {
        if (mProgressDialog == null)
            mProgressDialog = ProgressDialog.show(getActivity(), "", getString(R.string.loading));
        mProgressDialog.show();
    }

    protected void onHideLoading() {
        if (mProgressDialog == null)
            return;
        mProgressDialog.dismiss();
    }
}
