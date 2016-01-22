package com.ethanco.anno;

/**
 * @Description TODO
 * Created by YOLANDA on 2016-01-21.
 */
public class TransitionBean {

    private Transition allTransition;
    private Transition enterTransition;
    private Transition exitTransition;

    public Transition getAllTransition() {
        return allTransition;
    }

    public void setAllTransition(Transition allTransition) {
        this.allTransition = allTransition;
    }

    public Transition getEnterTransition() {
        return enterTransition;
    }

    public void setEnterTransition(Transition enterTransition) {
        this.enterTransition = enterTransition;
    }

    public Transition getExitTransition() {
        return exitTransition;
    }

    public void setExitTransition(Transition exitTransition) {
        this.exitTransition = exitTransition;
    }
}
