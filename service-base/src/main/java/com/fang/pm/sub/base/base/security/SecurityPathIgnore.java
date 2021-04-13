package com.fang.pm.sub.base.base.security;

import java.util.ArrayList;
import java.util.List;

public class SecurityPathIgnore {

    private String[] paths;

    public SecurityPathIgnore(String... paths) {
        this.paths = paths;
    }

    public String[] getPaths() {
        return paths;
    }

    public void setPaths(String[] paths) {
        this.paths = paths;
    }
}
