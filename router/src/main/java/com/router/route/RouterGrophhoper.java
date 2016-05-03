package com.router.route;

import com.graphhopper.GraphHopper;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.HintsMap;
import com.graphhopper.routing.util.Weighting;

import java.util.Set;

/**
 * Created by daoshibushi on 2016/4/29.
 */
class RouterGrophhoper extends GraphHopper {

    Set<Integer> forbiddenEdges;
    public void determineForbiddenEdges() {
//        forbiddenEdges =
    }

    @Override
    public Weighting createWeighting(HintsMap wMap, FlagEncoder encoder) {
        String weighting = wMap.getWeighting();
        if ("BLOCKING".equalsIgnoreCase(weighting))
            return new BlockingWeighting(encoder, forbiddenEdges);
        else
            return super.createWeighting(wMap, encoder);
    }


}