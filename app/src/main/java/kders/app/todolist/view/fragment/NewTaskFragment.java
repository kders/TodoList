package kders.app.todolist.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kders.app.todolist.R;
import kders.app.todolist.databinding.FragmentAddTaskBinding;
import kders.app.todolist.view.activity.HomeActivity;
import kders.app.todolist.view.common.BaseFragment;

/**
 * Created by user on 09/10/2017.
 */

public class NewTaskFragment extends BaseFragment{

    private FragmentAddTaskBinding mBinding;


    public IAddTaskListener getListener() {
        return mListener;
    }

    public void setListener(IAddTaskListener mListener) {
        this.mListener = mListener;
    }

    private IAddTaskListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_task, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getType() {
        return HomeActivity.FRAGMENT_NEW_TASK;
    }
}
