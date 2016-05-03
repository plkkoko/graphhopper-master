package com.router.route;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.InstructionAnnotation;
import com.graphhopper.util.Translation;

/**
 * Created by daoshibushi on 2016/4/29.
 */
public class RouterFlagEncoder implements FlagEncoder {
    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public double getMaxSpeed() {
        return 0;
    }

    @Override
    public double getSpeed(long flags) {
        return 0;
    }

    @Override
    public long setSpeed(long flags, double speed) {
        return 0;
    }

    @Override
    public double getReverseSpeed(long flags) {
        return 0;
    }

    @Override
    public long setReverseSpeed(long flags, double speed) {
        return 0;
    }

    @Override
    public long setAccess(long flags, boolean forward, boolean backward) {
        return 0;
    }

    @Override
    public long setProperties(double speed, boolean forward, boolean backward) {
        return 0;
    }

    @Override
    public boolean isForward(long flags) {
        return false;
    }

    @Override
    public boolean isBackward(long flags) {
        return false;
    }

    @Override
    public boolean isBool(long flags, int key) {
        return false;
    }

    @Override
    public long setBool(long flags, int key, boolean value) {
        return 0;
    }

    @Override
    public long getLong(long flags, int key) {
        return 0;
    }

    @Override
    public long setLong(long flags, int key, long value) {
        return 0;
    }

    @Override
    public double getDouble(long flags, int key) {
        return 0;
    }

    @Override
    public long setDouble(long flags, int key, double value) {
        return 0;
    }

    @Override
    public boolean supports(Class<?> feature) {
        return false;
    }

    @Override
    public InstructionAnnotation getAnnotation(long flags, Translation tr) {
        return null;
    }

    @Override
    public boolean isRegistered() {
        return false;
    }

    @Override
    public boolean isTurnRestricted(long flags) {
        return false;
    }

    @Override
    public double getTurnCost(long flags) {
        return 0;
    }

    @Override
    public long getTurnFlags(boolean restricted, double costs) {
        return 0;
    }
}
