package dagger;

import javax.inject.Inject;

/**
 * Created by shixin on 2017/8/29 0029.
 */

public class Car {

    @Inject
    public Car(){
    }

    public String test(){
        return "测试";
    }

}
