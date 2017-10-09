package kders.app.todolist.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kders.app.todolist.R;
import kders.app.todolist.databinding.FragmentTaskListBinding;
import kders.app.todolist.view.activity.HomeActivity;
import kders.app.todolist.view.common.BaseFragment;

/**
 * Created by user on 09/10/2017.
 */

public class TaskListFragment extends BaseFragment {
    private FragmentTaskListBinding mBinding;
    private TaskRowAdapter mTaskRowAdapter;

    public ITaskListListener getListener() {
        return mListener;
    }

    public void setListener(ITaskListListener mListener) {
        this.mListener = mListener;
    }

    private ITaskListListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_list, container, false);
        mTaskRowAdapter = new TaskRowAdapter();
        mBinding.recyclerViewTaskList.setHasFixedSize(true);
        mBinding.recyclerViewTaskList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.recyclerViewTaskList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mBinding.recyclerViewTaskList.setAdapter(mTaskRowAdapter);

        mBinding.btnAddEvent.setOnClickListener(v-> mListener.onClickNewEvent());
        mBinding.btnAddTask.setOnClickListener(v -> mListener.onClickNewTask());
        mBinding.btnAddTodo.setOnClickListener(v -> mListener.onClickNewTodo());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getType() {
        return HomeActivity.FRAGMENT_TASK_LIST;
    }


}
