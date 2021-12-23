package org.osrs.debug;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import org.osrs.api.methods.MethodContext;
import org.osrs.api.objects.GameObject;
import org.osrs.api.wrappers.BoundaryObject;
import org.osrs.util.Data;

public class BoundaryObjDebug {
	private MethodContext methods = null;
	public BoundaryObjDebug(MethodContext methods){
		this.methods=methods;
	}
	public Graphics paint(Graphics g){
		if(Data.clientFrame.boundaryObjDebugOption.getState()){
			for(GameObject go : methods.objects.getAllObjects()){
				if(go.getLocation().getPlane()!=methods.game.currentPlane())
					continue;
				if(go.getAccessor() instanceof BoundaryObject){
					if(go.isHovering()){
						for(Polygon p : go.getWireframe()){
							g.drawPolygon(p);
						}
						Point pt = go.getScreenLocation();
						g.drawString("ID : "+go.getID(), pt.x+15, pt.y);
						pt.y+=15;
						g.drawString("Name : "+go.getName(), pt.x+15, pt.y);
						pt.y+=15;
						g.drawString("Location : "+go.getLocation(), pt.x+15, pt.y);
						pt.y+=15;
						g.drawString("Orientation : "+go.getOrientation(), pt.x+15, pt.y);
						pt.y+=15;
					}
				}
			}
		}
		return g;
	}
}
