package com.cisco.acisizing.force.api;

public enum ApiVersion {
    V24("v24.0"),
    V23("v23.0"),
    V22("v22.0"),
    V30("v30.0"),
    V31("v31.0"),
    V32("v32.0"),
    V29("v29.0"),
    V28("v28.0"),
    V27("v27.0"),

    DEFAULT_VERSION("v32.0");

    final String v;

    ApiVersion(String v) {
        this.v = v;
    }

    public String toString() {
        return v;
    }

}