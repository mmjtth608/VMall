package cn.a17xiezuo.vmall.Presenter.impl;

import android.content.Context;

import cn.a17xiezuo.vmall.Presenter.IHomePresenter;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.logic.IPersonInteractor;
import cn.a17xiezuo.vmall.logic.impl.PersonInteractorImpl;
import cn.a17xiezuo.vmall.ui.view.IHomeView;

/**
 * Created by wuyunan on 16/6/27.
 */
public class HomePresenterImpl implements IHomePresenter, IPersonInteractor.OnPersonFinishedListener {

    IHomeView mainView;
    IPersonInteractor personInteractor;
    Context mComtext;

    public HomePresenterImpl(Context context, IHomeView mainView) {
        this.mainView = mainView;
        this.personInteractor = new PersonInteractorImpl();
        this.mComtext = context;
    }

    @Override
    public void getPersionInfo() {
        if (mainView != null) {
            mainView.showProgress();
        }
        this.personInteractor.getPersonInfo(mComtext, this);
    }


    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess(Person person) {
        if (mainView != null) {
            mainView.setPerson(person);
        }
    }

}
