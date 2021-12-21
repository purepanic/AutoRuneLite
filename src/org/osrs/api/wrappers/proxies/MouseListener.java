package org.osrs.api.wrappers.proxies;

import org.osrs.injection.bytescript.BClass;
import org.osrs.injection.bytescript.BFunction;
import org.osrs.injection.bytescript.BMethod;
import org.osrs.injection.bytescript.BVar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@BClass(name="MouseListener")
public class MouseListener implements org.osrs.api.wrappers.MouseListener{
	@BVar
	public int realX=0;
	@BVar
	public int realY=0;
	@BVar
	public int realPressX=0;
	@BVar
	public int realPressY=0;
	@BVar
	public long realPressTime=0;
	@BVar
	public long realLastMoveTime=0;
	@BVar
	public boolean realPresent=false;
	@BVar
	public boolean realPressed=false;
	@BVar
	public int clientX=0;
	@BVar
	public int clientY=0;
	@BVar
	public int clientPressX = 0;
	@BVar
	public int clientPressY = 0;
	@BVar
	public long clientPressTime = 0;
	@BVar
	public boolean clientPresent=false;
	@BVar
	public boolean clientPressed=false;

	@BMethod(name="mouseClicked0")
	public void mouseClicked0(MouseEvent e){}
	@BMethod(name="mouseDragged0")
	public void mouseDragged0(MouseEvent e){}
	@BMethod(name="mouseEntered0")
	public void mouseEntered0(MouseEvent e){}
	@BMethod(name="mouseExited0")
	public void mouseExited0(MouseEvent e){}
	@BMethod(name="mouseMoved0")
	public void mouseMoved0(MouseEvent e){}
	@BMethod(name="mousePressed0")
	public void mousePressed0(MouseEvent e){}
	@BMethod(name="mouseReleased0")
	public void mouseReleased0(MouseEvent e){}

	@BFunction
	@Override
	public int getRealX(){
		return realX;
	}
	@BFunction
	@Override
	public int getRealY(){
		return realY;
	}
	@BFunction
	@Override
	public int getRealPressX() {
		return realPressX;
	}
	@BFunction
	@Override
	public int getRealPressY() {
		return realPressY;
	}
	@BFunction
	@Override
	public long getRealPressTime() {
		return realPressTime;
	}
	@BFunction
	@Override
	public boolean isRealPressed() {
		return realPressed;
	}
	@BFunction
	@Override
	public boolean isRealPresent() {
		return realPresent;
	}
	@BFunction
	@Override
	public int getX() {
		return clientX;
	}
	@BFunction
	@Override
	public int getY() {
		return clientY;
	}
	@BFunction
	@Override
	public int getPressX() {
		return clientPressX;
	}
	@BFunction
	@Override
	public int getPressY() {
		return clientPressY;
	}
	@BFunction
	@Override
	public long getPressTime() {
		return clientPressTime;
	}
	@BFunction
	@Override
	public boolean isPressed() {
		return clientPressed;
	}
	@BFunction
	@Override
	public boolean isPresent() {
		return clientPresent;
	}
	@BFunction
	@Override
	public final void mouseClicked(final MouseEvent e) {
		//System.out.println(e.toString());
		realX=e.getX();
		realY=e.getY();

		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientX = e.getX();
			clientY = e.getY();
			mouseClicked0(e);
		//}
		//else
		//	System.out.println("Script is running.");
			
		e.consume();
	}
	@BFunction
	@Override
	public final void mouseDragged(final MouseEvent e) {
		//System.out.println(e.toString());
		realX=e.getX();
		realY=e.getY();

		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientX = e.getX();
			clientY = e.getY();
			mouseDragged0(e);
		//}
		e.consume();
	}
	@BFunction
	@Override
	public final void mouseEntered(final MouseEvent e) {
		//System.out.println(e.toString());
		realPresent=true;
		realX=e.getX();
		realY=e.getY();
		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientX = e.getX();
			clientY = e.getY();
			clientPresent = true;
			mouseEntered0(e);
		//}
	
		e.consume();
	}
	@BFunction
	@Override
	public final void mouseExited(final MouseEvent e) {
		//System.out.println(e.toString());
		realPresent=false;
		realX=e.getX();
		realY=e.getY();
		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientX = e.getX();
			clientY = e.getY();
			clientPresent = false;
			mouseExited0(e);
		//}
	
		e.consume();
	}
	@BFunction
	@Override
	public final void mouseMoved(final MouseEvent e) {
		//System.out.println("Source : "+e.getSource());
		if(realLastMoveTime==0)
			realLastMoveTime = System.currentTimeMillis();
		//byte[] seed = ByteBuffer.allocate(8).putLong((System.currentTimeMillis()-realLastMoveTime)+e.getXOnScreen()+e.getYOnScreen()).array();
		//Data.randomSeed[Data.randomSeedIndice++] = (byte) (seed[7] * (methods.calculations.random(10)%2==1?-1:1));
		//if(Data.randomSeedIndice==8)
		//	Data.randomSeedIndice=0;
		realX=e.getX();
		realY=e.getY();
		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientX = e.getX();
			clientY = e.getY();
			mouseMoved0(e);
		//}
	
		realLastMoveTime = System.currentTimeMillis();
		e.consume();
	}
	@BFunction
	@Override
	public final void mousePressed(final MouseEvent e) {
		//System.out.println(e.toString());
		realPressed=true;
		realX=e.getX();
		realY=e.getY();
		realPressX = e.getX();
		realPressY = e.getY();
		realPressTime = System.currentTimeMillis();
		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientPressed = true;
			clientX = e.getX();
			clientY = e.getY();
			clientPressX = e.getX();
			clientPressY = e.getY();
			clientPressTime = System.currentTimeMillis();
			mousePressed0(e);
		//}
		e.consume();
	}
	@BFunction
	@Override
	public final void mouseReleased(final MouseEvent e) {
	//	System.out.println(e.toString());
		realX=e.getX();
		realY=e.getY();
		realPressed = false;
		//ScriptDef script = Data.currentScripts.get(instance);
		//if(script==null || script.isPaused){
			clientX = e.getX();
			clientY = e.getY();
			clientPressed = false;
			mouseReleased0(e);
		//}
		e.consume();
	}
	@BFunction
	@Override
	public final void sendEvent(final MouseEvent e) {
		//System.out.println("Sending event : "+e.toString());
		clientX = e.getX();
		clientY = e.getY();
		try {
			if (e.getID() == MouseEvent.MOUSE_CLICKED) {
				mouseClicked0(e);
			} else if (e.getID() == MouseEvent.MOUSE_DRAGGED) {
				mouseDragged0(e);
			} else if (e.getID() == MouseEvent.MOUSE_ENTERED) {
				clientPresent = true;
				mouseEntered0(e);
			} else if (e.getID() == MouseEvent.MOUSE_EXITED) {
				clientPresent = false;
				mouseExited0(e);
			} else if (e.getID() == MouseEvent.MOUSE_MOVED) {
				mouseMoved0(e);
			} else if (e.getID() == MouseEvent.MOUSE_PRESSED) {
				clientPressX = e.getX();
				clientPressY = e.getY();
				clientPressTime = System.currentTimeMillis();
				clientPressed = true;
				mousePressed0(e);
			} else if (e.getID() == MouseEvent.MOUSE_RELEASED) {
				clientPressed = false;
				mouseReleased0(e);
			} else {
				throw new InternalError(e.toString());
			}
		} catch (@SuppressWarnings("unused") final NullPointerException npe) {
			// client may throw NPE when a listener
			// is being re-instantiated.
		}
		if (e.getID() == MouseEvent.MOUSE_CLICKED || e.getID() == MouseEvent.MOUSE_PRESSED ||
				e.getID() == MouseEvent.MOUSE_RELEASED) {
			/*ArrayList<java.awt.event.MouseListener> mls = Client.clientInstance.getRegisteredMouseListeners();
			for(java.awt.event.MouseListener ml : mls){
				if(ml==null || (ml instanceof ScriptDef && !((ScriptDef)ml).isAlive())){
					Client.clientInstance.unregisterMouseListener(ml);
				}
				else
					ml.mouseClicked(e);
			}*/
		}
	}
	@BFunction
	@Override
	public void paint(Graphics g){
		if(isPressed())
			g.setColor(new Color(255, 127, 0, 155));
		else
			g.setColor(new Color(0, 255, 0, 155));
		g.fillOval(clientX-10, clientY-3, 20, 6);
		g.fillOval(clientX-3, clientY-10, 6, 20);
		g.setColor(Color.CYAN);
	}
}