package com.apollo.firstBadVersion;

public class VersionControl {
    public boolean isBadVersion(int version) {
        if (version > 34) {
            return true;
        }
        return false;
    }
}
