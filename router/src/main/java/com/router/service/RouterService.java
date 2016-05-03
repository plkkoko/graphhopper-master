package com.router.service;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.PathWrapper;
import com.graphhopper.routing.util.EdgeFilter;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.storage.index.LocationIndex;
import com.graphhopper.storage.index.QueryResult;
import com.graphhopper.util.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 * Created by daoshibushi on 2016/4/29.
 */

public class RouterService {

    String osmFile="G:\\boss\\osmdata\\chengdu.xml";
    String graphFolder="G:\\boss\\osmdata\\osm";

    double latFrom=30.767725;
    double lonFrom=103.978987;
    double latTo=30.669477;
    double lonTo=104.068036;

    public RouterService(double latFrom, double lonFrom, double latTo, double lonTo) {
        this.latFrom = latFrom;
        this.lonFrom = lonFrom;
        this.latTo = latTo;
        this.lonTo = lonTo;
    }

    public RouterService(){
        super();
    }
    public String getOsmFile() {
        return osmFile;
    }

    public void setOsmFile(String osmFile) {
        this.osmFile = osmFile;
    }

    public String getGraphFolder() {
        return graphFolder;
    }

    public void setGraphFolder(String graphFolder) {
        this.graphFolder = graphFolder;
    }

    public double getLatFrom() {
        return latFrom;
    }

    public void setLatFrom(double latFrom) {
        this.latFrom = latFrom;
    }

    public double getLonFrom() {
        return lonFrom;
    }

    public void setLonFrom(double lonFrom) {
        this.lonFrom = lonFrom;
    }

    public double getLatTo() {
        return latTo;
    }

    public void setLatTo(double latTo) {
        this.latTo = latTo;
    }

    public double getLonTo() {
        return lonTo;
    }

    public void setLonTo(double lonTo) {
        this.lonTo = lonTo;
    }

    public String getPath(){

        GraphHopper hopper = new GraphHopper().forServer();
        hopper.setOSMFile(osmFile);

        hopper.setGraphHopperLocation(graphFolder);
        hopper.setEncodingManager(new EncodingManager("car"));

        hopper.importOrLoad();

        LocationIndex index = hopper.getLocationIndex();
        QueryResult qr =index.findClosest(latFrom, lonFrom, EdgeFilter.ALL_EDGES );
        EdgeIteratorState edge = qr.getClosestEdge();


        GHRequest req = new GHRequest(latFrom, lonFrom, latTo, lonTo).
                setWeighting("fastest").
                setVehicle("car").
                setLocale(Locale.US);
        GHResponse rsp = hopper.route(req);


        if(rsp.hasErrors()) {
            // handle them!
            // rsp.getErrors()
            return "ERROR";
        }


        PathWrapper path = rsp.getBest();


        PointList pointList = path.getPoints();
        double distance = path.getDistance();
        long timeInMs = path.getTime();

        InstructionList il = path.getInstructions();

        for(Instruction instruction : il) {
            instruction.getDistance();
//            ...
        }

        List<Map<String, Object>> iList = il.createJson();




        List<GPXEntry> list = il.createGPXList();
        return iList.toString();
    }

}
