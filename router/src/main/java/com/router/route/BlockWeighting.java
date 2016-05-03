package com.router.route;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.HintsMap;
import com.graphhopper.routing.util.Weighting;
import com.graphhopper.util.EdgeIteratorState;

import java.util.Set;

/**
 * Created by daoshibushi on 2016/4/29.
 */
class BlockingWeighting implements Weighting
{
    private final FlagEncoder encoder;
    private final double maxSpeed;
    private Set<Integer> forbiddenEdges;

    public BlockingWeighting( FlagEncoder encoder, Set<Integer> forbiddenEdges)
    {
        this.encoder = encoder;
        this.maxSpeed = encoder.getMaxSpeed();
        this.forbiddenEdges = forbiddenEdges;
    }

    @Override
    public double getMinWeight( double distance )
    {
        return distance / maxSpeed;
    }

    @Override
    public double calcWeight(EdgeIteratorState edgeState, boolean reverse, int prevOrNextEdgeId )
    {
        if(forbiddenEdges.contains(edgeState.getEdge()))
            return Double.POSITIVE_INFINITY;

        double speed = reverse ? encoder.getReverseSpeed(edgeState.getFlags()) : encoder.getSpeed(edgeState.getFlags());
        if (speed == 0)
            return Double.POSITIVE_INFINITY;
        return edgeState.getDistance() / speed;
    }


    @Override
    public FlagEncoder getFlagEncoder(){
        return null;
    }

    @Override
    public String getName(){
        return null;
    }

    /**
     * Returns true if the specified weighting and encoder matches to this Weighting.
     */
    public boolean matches( HintsMap map ){
        return true;
    }
    @Override
    public String toString()
    {
        return "BLOCKING";
    }
}