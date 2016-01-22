package com.ethanco.anno;

/**
 * @Description TODO
 * Created by YOLANDA on 2016-01-21.
 */
public enum Transition {
    Fade("new Fade()"), Explode("new Explode()"), Slide("new Slide()");

    private String trans;

    Transition(String trans) {
        this.trans = trans;
    }

    public String getTrans() {
        return this.trans;
    }
}
