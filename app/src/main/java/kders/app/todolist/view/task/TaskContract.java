package kders.app.todolist.view.task;

import kders.app.todolist.presenter.BasePresenter;
import kders.app.todolist.view.BaseView;

/**
 *
 * Created by khanhngan on 28/10/2017.
 */

public interface TaskContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
